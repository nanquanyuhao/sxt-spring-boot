package net.nanquanyuhao.springbootspringmvcmybatis.controller;

import net.nanquanyuhao.springbootspringmvcmybatis.pojo.User;
import net.nanquanyuhao.springbootspringmvcmybatis.service.UserServcice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(User user) {
        this.userService.addUser(user);
        return "ok";
    }

    /**
     * 查询全部用户
     */
    @RequestMapping("/findUserAll")
    public String findUserAll(Model model) {
        List<User> list = this.userService.findUserAll();
        model.addAttribute("list", list);

        return "showUsers";
    }

    /**
     * 根据用户id查询用户
     */
    @RequestMapping("/findUserById")
    public String findUserById(Integer id, Model model) {
        User user = this.userService.findUserById(id);
        model.addAttribute("user", user);

        return "updateUser";
    }

    /**
     * 更新用户
     */
    @RequestMapping("/editUser")
    public String editUser(User users){
        this.userService.updateUser(users);
        return "ok";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delUser")
    public String delUser(Integer id){
        this.userService.deleteUserById(id);
        return "redirect:/user/findUserAll";
    }
}
