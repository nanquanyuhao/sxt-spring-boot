package net.nanquanyuhao.controller;

import net.nanquanyuhao.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by nanquanyuhao on 2018/11/14.
 * <p>
 * Spring Boot 表单数据校验
 */
@Controller
public class UserController {

    @RequestMapping("/addUser")
    public String showPage() {
        return "add";
    }

    /**
     * 完成用户添加
     */
    @RequestMapping("/save")
    public String saveUser(User user) {
        System.out.println(user);
        return "ok";
    }
}
