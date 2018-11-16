package net.nanquanyuhao.service;

import net.nanquanyuhao.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by nanquanyuhao on 2018/11/16.
 */
public interface UserService {

    List<User> findUserAll();

    User findUserById(Integer id);

    Page<User> findUserByPage(Pageable pageable);

    void saveUser(User user);
}
