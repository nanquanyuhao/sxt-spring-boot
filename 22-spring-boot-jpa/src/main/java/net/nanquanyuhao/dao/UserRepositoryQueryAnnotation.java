package net.nanquanyuhao.dao;

import net.nanquanyuhao.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by nanquanyuhao on 2018/11/15.
 * <p>
 * Repository @Query
 */
public interface UserRepositoryQueryAnnotation extends Repository<User, Integer> {

    @Query("from User where name = ?1")
    List<User> queryByNameUseHQL(String name);

    @Query(value = "select * from t_user where name = ?", nativeQuery = true)
    List<User> queryByNameUseSQL(String name);

    @Query("update User set name  = ?1 where id  = ?2")
    @Modifying
        //需要执行一个更新操作
    void updateUserNameById(String name, Integer id);
}
