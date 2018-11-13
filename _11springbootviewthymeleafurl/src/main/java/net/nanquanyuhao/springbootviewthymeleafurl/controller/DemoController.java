package net.nanquanyuhao.springbootviewthymeleafurl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nanquanyuhao on 2018/11/13.
 * <p>
 * Thymeleaf 入门案例
 */
@Controller
public class DemoController {

    @RequestMapping("/{page}")
    public String showInfo(@PathVariable String page, Integer id, String name) {
        System.out.println(id + "--" + name);
        return page;
    }
}
