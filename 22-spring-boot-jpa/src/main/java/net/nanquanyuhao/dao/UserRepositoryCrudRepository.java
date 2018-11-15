package net.nanquanyuhao.dao;

import net.nanquanyuhao.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nanquanyuhao on 2018/11/15.
 */
public interface UserRepositoryCrudRepository extends CrudRepository<User, Integer> {
}
