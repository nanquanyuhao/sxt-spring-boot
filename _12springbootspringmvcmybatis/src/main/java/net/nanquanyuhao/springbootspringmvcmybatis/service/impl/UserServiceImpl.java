package net.nanquanyuhao.springbootspringmvcmybatis.service.impl;

import net.nanquanyuhao.springbootspringmvcmybatis.mapper.UserMapper;
import net.nanquanyuhao.springbootspringmvcmybatis.pojo.User;
import net.nanquanyuhao.springbootspringmvcmybatis.service.UserServcice;
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
}
