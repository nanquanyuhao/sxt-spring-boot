package net.nanquanyuhao.controller;

import cn.chinaunicom.sdsi.paas.file.FileService;
import cn.chinaunicom.sdsi.paas.file.exception.PaasException;
import cn.chinaunicom.sdsi.paas.file.to.DownloadFileInfo;
import net.nanquanyuhao.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nanquanyuhao on 2018/11/12.
 */
@Controller
public class HelloWorld {

    @Autowired
    private FileService fileService;

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String, Object> showHelloWorld() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "HelloWorld");
        return map;
    }

    @GetMapping("/file")
    public ResponseEntity<byte[]> file(HttpServletRequest request) {

        DownloadFileInfo downloadFileInfo = null;
        try {
            downloadFileInfo = fileService.download("2bc445f3-e470-4fab-afea-23da910e4589");
        } catch (PaasException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String fileName = downloadFileInfo.getFileName();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", ResponseUtils.responseFileName(fileName,
                request.getHeader("USER-AGENT")));
        // headers.add("Content-Disposition", "attachment;filename="+fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        InputStream input = downloadFileInfo.getInput();


        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        try {
            while (true) {
                if (!((ch = input.read()) != -1)) break;
                swapStream.write(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return new ResponseEntity<>(swapStream.toByteArray(), headers, HttpStatus.OK);
    }

}
