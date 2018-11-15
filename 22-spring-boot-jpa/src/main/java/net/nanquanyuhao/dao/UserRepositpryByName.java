package net.nanquanyuhao.dao;

import net.nanquanyuhao.pojo.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by nanquanyuhao on 2018/11/15.
 * <p>
 * Repository 接口的方法名称命名查询
 */
public interface UserRepositpryByName extends Repository<User, Integer> {

    // 方法的名称必须要遵循驼峰是明明规则。findBy（关键字） + 属性名称（首字母要大写） + 查询条件（首字母要大写）
    List<User> findByName(String name);

    List<User> findByNameAndAge(String name, Integer age);

    List<User> findByNameLike(String name);
}
