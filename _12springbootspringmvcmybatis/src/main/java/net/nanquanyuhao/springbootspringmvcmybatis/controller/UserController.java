package net.nanquanyuhao.springbootspringmvcmybatis.controller;

import net.nanquanyuhao.springbootspringmvcmybatis.pojo.User;
import net.nanquanyuhao.springbootspringmvcmybatis.service.UserServcice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nanquanyuhao on 2018/11/14.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServcice userService;

    /**
     * 页面跳转
     */
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page) {
        return page;
    }

    /**
     * 添加用户
     *
     * @param users
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(User users) {
        this.userService.addUser(users);
        return "ok";
    }
}
