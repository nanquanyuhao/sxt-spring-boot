package net.nanquanyuhao.service.impl;

import net.nanquanyuhao.mapper.UserMapper;
import net.nanquanyuhao.pojo.User;
import net.nanquanyuhao.service.UserServcice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nanquanyuhao on 2018/11/14.
 */
@Service
@Transactional
public class UserServiceImpl implements UserServcice {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        this.userMapper.insertUser(user);
    }

    @Override
    public List<User> findUserAll() {
        return this.userMapper.selectUserAll();
    }

    @Override
    public User findUserById(Integer id) {
        return this.userMapper.selectUserById(id);
    }

    @Override
    public void updateUser(User user) {
        this.userMapper.updateUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        this.userMapper.deleteUserById(id);
    }
}
