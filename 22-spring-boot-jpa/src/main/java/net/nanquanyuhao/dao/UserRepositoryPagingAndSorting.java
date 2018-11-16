package net.nanquanyuhao.dao;

import net.nanquanyuhao.pojo.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by nanquanyuhao on 2018/11/16.
 * <p>
 * PagingAndSortingRepository 接口
 */
public interface UserRepositoryPagingAndSorting extends PagingAndSortingRepository<User, Integer> {

}
