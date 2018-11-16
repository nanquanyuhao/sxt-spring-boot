package net.nanquanyuhao.service.impl;

import net.nanquanyuhao.dao.UserRepository;
import net.nanquanyuhao.pojo.User;
import net.nanquanyuhao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nanquanyuhao on 2018/11/16.
 * <p>
 * UserService 接口实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(value = "user")
    public List<User> findUserAll() {
        return this.userRepository.findAll();
    }

    @Override
    // @Cacheable：对当前查询的对象做缓存处理
    @Cacheable(value = "user")
    public User findUserById(Integer id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    @Cacheable(value = "user", key = "#pageable.pageSize")
    public Page<User> findUserByPage(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    // @CacheEvict(value = "user", allEntries = true)：清除缓存中以 user 缓存策略缓存的对象
    @CacheEvict(value = "user", allEntries = true)
    public void saveUser(User user) {
        this.userRepository.save(user);
    }
}
