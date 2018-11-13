package net.nanquanyuhao.springbootviewthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by nanquanyuhao on 2018/11/13.
 *
 * Thymeleaf 入门案例
 */
@Controller
public class DemoController {

    @RequestMapping("/show")
    public String showInfo(Model model){
        model.addAttribute("msg", "Thymeleaf 第一个案例");
        model.addAttribute("key", new Date());
        return "index";
    }
}
