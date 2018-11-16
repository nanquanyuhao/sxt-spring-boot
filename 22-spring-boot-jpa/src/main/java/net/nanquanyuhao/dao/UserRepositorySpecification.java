package net.nanquanyuhao.dao;

import net.nanquanyuhao.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by nanquanyuhao on 2018/11/16.
 *
 * JpaSpecificationExecutor
 */
public interface UserRepositorySpecification extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

}
