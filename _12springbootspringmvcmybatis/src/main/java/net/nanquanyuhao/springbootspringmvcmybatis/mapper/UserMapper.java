package net.nanquanyuhao.springbootspringmvcmybatis.mapper;

import net.nanquanyuhao.springbootspringmvcmybatis.pojo.User;

import java.util.List;

/**
 * Created by nanquanyuhao on 2018/11/14.
 */
public interface UserMapper {

    void insertUser(User user);

    List<User> selectUserAll();
}
