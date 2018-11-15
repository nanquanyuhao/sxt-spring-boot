package net.nanquanyuhao.service;

import net.nanquanyuhao.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nanquanyuhao on 2018/11/15.
 */
@Service
public class UserServiceImpl {

    @Autowired
    private UserDaoImpl userDaoImpl;

    public void addUser(){
        this.userDaoImpl.saveUser();
    }
}
