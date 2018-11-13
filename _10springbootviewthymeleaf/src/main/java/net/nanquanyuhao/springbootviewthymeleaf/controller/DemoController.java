package net.nanquanyuhao.springbootviewthymeleaf.controller;

import net.nanquanyuhao.springbootviewthymeleaf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

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

    @RequestMapping("/show2")
    public String showInfo2(Model model){
        model.addAttribute("sex", "女");
        model.addAttribute("id","1");
        return "index2";
    }

    @RequestMapping("/show3")
    public String showInfo3(Model model){
        List<User> list = new ArrayList<>();
        list.add(new User(1,"张三",20));
        list.add(new User(2,"李四",22));
        list.add(new User(3,"王五",24));

        model.addAttribute("list", list);
        return "index3";
    }

    @RequestMapping("/show4")
    public String showInfo4(Model model){
        Map<String, User> map = new HashMap<>();
        map.put("u1", new User(1,"张三",20));
        map.put("u2", new User(2,"李四",22));
        map.put("u3", new User(3,"王五",24));

        model.addAttribute("map", map);
        return "index4";
    }

    @RequestMapping("/show5")
    public String showInfo5(HttpServletRequest request){
        request.setAttribute("req", "HttpServletRequest");
        request.getSession().setAttribute("sess", "HttpSession");
        request.getSession().getServletContext().setAttribute("app", "Application");
        return "index5";
    }
}
