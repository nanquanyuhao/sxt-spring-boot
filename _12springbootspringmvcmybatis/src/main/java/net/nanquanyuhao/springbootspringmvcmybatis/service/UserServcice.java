package net.nanquanyuhao.springbootspringmvcmybatis.service;

import net.nanquanyuhao.springbootspringmvcmybatis.pojo.User;

import java.util.List;

/**
 * Created by nanquanyuhao on 2018/11/14.
 */
public interface UserServcice {

    void addUser(User user);

    List<User> findUserAll();

    User findUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);
}
