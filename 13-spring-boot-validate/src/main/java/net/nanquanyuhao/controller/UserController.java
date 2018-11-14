package net.nanquanyuhao.controller;

import net.nanquanyuhao.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by nanquanyuhao on 2018/11/14.
 * <p>
 * Spring Boot 表单数据校验
 */
@Controller
public class UserController {

    /**
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String showPage(User user) {
        return "add";
    }

    /**
     * 完成用户添加
     *
     * @Valid 开启对 User 对象的数据校验
     * BindingResult:封装了校验的结果
     */
    @RequestMapping("/save")
    public String saveUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "add";
        }

        System.out.println(user);
        return "ok";
    }
}
