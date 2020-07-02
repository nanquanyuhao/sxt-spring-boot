package net.nanquanyuhao.controller;

import cn.chinaunicom.sdsi.paas.file.FileService;
import cn.chinaunicom.sdsi.paas.file.exception.PaasException;
import cn.chinaunicom.sdsi.paas.file.to.DownloadFileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Map<String, Object> showHelloWorld(){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "HelloWorld");
        return map;
    }

    @GetMapping("/file")
    public ResponseEntity<byte[]> file(){

        DownloadFileInfo downloadFileInfo = null;
        try {
            downloadFileInfo = fileService.download("70e68855-b637-44da-9e6b-96ec4c57591c");
        } catch (PaasException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String fileName = downloadFileInfo.getFileName();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        byte[] fileByteArray = null;
        try {
            fileByteArray =  IOUtils.toByteArray(downloadFileInfo.getInput());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(fileByteArray, headers, HttpStatus.OK);
    }

}
