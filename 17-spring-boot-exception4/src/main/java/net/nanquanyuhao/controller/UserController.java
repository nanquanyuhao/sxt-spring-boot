package net.nanquanyuhao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nanquanyuhao on 2018/11/14.
 */
@Controller
public class UserController {

    @RequestMapping("/showUsers")
    public String showUser() {
        String str = null;
        str.length();
        return "index";
    }

    @RequestMapping("/showUsers2")
    public String showUser2() {
        int a = 100 / 0;
        return "index";
    }
}
