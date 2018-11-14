package net.nanquanyuhao.springbootspringmvcmybatis.mapper;

import net.nanquanyuhao.springbootspringmvcmybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by nanquanyuhao on 2018/11/14.
 */
public interface UserMapper {

    void insertUser(User user);
}
