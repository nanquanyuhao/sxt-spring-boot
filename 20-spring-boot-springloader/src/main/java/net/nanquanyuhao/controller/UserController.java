package net.nanquanyuhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nanquanyuhao on 2018/11/15.
 * <p>
 * SpringBoot----SpringLoader
 */
@Controller
public class UserController {

    @RequestMapping("/show")
    public String showPage() {
        System.out.println("ShowPage...init");
        return "index";
    }
}
