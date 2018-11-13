package net.nanquanyuhao.springbootviewjsp.controller;

import net.nanquanyuhao.springbootviewjsp.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanquanyuhao on 2018/11/13.
 * <p>
 * Spring Boot 整合 jsp
 */
@Controller
public class UserController {

    /**
     * 处理请求，返回数据
     */
    @RequestMapping("/showUser")
    public String showUser(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "张三", 20));
        list.add(new User(2, "李四", 22));
        list.add(new User(3, "王五", 24));

        // 需要一个 model 对象
        model.addAttribute(list);
        // 跳转视图
        return "userList";
    }
}
