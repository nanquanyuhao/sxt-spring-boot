package net.nanquanyuhao.mapper;

import net.nanquanyuhao.pojo.User;

import java.util.List;

/**
 * Created by nanquanyuhao on 2018/11/14.
 */
public interface UserMapper {

    void insertUser(User user);

    List<User> selectUserAll();

    User selectUserById(Integer id);

    void updateUser(User user);

    void deleteUserById(Integer id);
}
