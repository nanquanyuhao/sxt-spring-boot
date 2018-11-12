package net.nanquanyuhao.springbootfileupload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nanquanyuhao on 2018/11/12.
 *
 * SpringBoot文件上传
 */
//@Controller
@RestController //表示该类下的方法的返回值会自动做json格式的转换
public class FileUploadController {

    /*
     * 处理文件上传
     */
    @RequestMapping("/fileUploadController")
    public Map<String, Object> fileUpload(MultipartFile filename)throws Exception{
        System.out.println(filename.getOriginalFilename());
        filename.transferTo(new File("C:/Users/nanquanyuhao/Desktop/" + filename.getOriginalFilename()));
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        return map;
    }
}
