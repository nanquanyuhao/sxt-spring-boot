package net.nanquanyuhao;

import net.nanquanyuhao.dao.UserRepository;
import net.nanquanyuhao.dao.UserRepositoryCrudRepository;
import net.nanquanyuhao.dao.UserRepositoryQueryAnnotation;
import net.nanquanyuhao.dao.UserRepositpryByName;
import net.nanquanyuhao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositpryByName userRepositpryByName;

    @Autowired
    private UserRepositoryQueryAnnotation userRepositoryQueryAnnotation;

    @Autowired
    private UserRepositoryCrudRepository userRepositoryCrudRepository;

    @Test
    public void contextLoads() {
        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setAddress("北京市海淀");

        this.userRepository.save(user);
    }

    /**
     * Repository——方法名称命名测试
     */
    @Test
    public void testFindByName() {
        List<User> list = this.userRepositpryByName.findByName("张三");

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Repository——方法名称命名测试
     */
    @Test
    public void testFindByNameAndAge() {
        List<User> list = this.userRepositpryByName.findByNameAndAge("张三", 20);

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Repository——方法名称命名测试
     */
    @Test
    public void testFindByNameLike() {
        List<User> list = this.userRepositpryByName.findByNameLike("张%");

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Repository—— @Query 测试
     */
    @Test
    public void testQueryByNameUseHQL() {
        List<User> list = this.userRepositoryQueryAnnotation.queryByNameUseHQL("张三");

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Repository—— @Query 测试
     */
    @Test
    public void testQueryByNameUseSQL() {
        List<User> list = this.userRepositoryQueryAnnotation.queryByNameUseSQL("张三");

        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * Repository--@Query测试
     */
    @Test
    @Transactional // @Transactional 与 @Test 一起使用时 事务是自动回滚的。
    @Rollback(false) // 取消自动回滚
    public void testUpdateUserNameById() {
        this.userRepositoryQueryAnnotation.updateUserNameById("张三三", 1);
    }

    /**
     * CrudRepository 测试
     */
    @Test
    public void testCrudRepositorySave() {
        User user = new User();
        user.setName("张三丰");
        user.setAge(32);
        user.setAddress("天津");

        this.userRepositoryCrudRepository.save(user);
    }

    /**
     * CrudRepository 测试
     */
    @Test
    public void testCrudRepositoryUpdate() {
        User user = new User();
        user.setId(4);
        user.setName("张三丰");
        user.setAge(40);
        user.setAddress("南京");

        this.userRepositoryCrudRepository.save(user);
    }

    /**
     * CrudRepository 测试
     */
    @Test
    public void testCrudRepositoryFindOne() {
        Optional<User> optional = this.userRepositoryCrudRepository.findById(4);
        System.out.println(optional.get());
    }

    /**
     * CrudRepository 测试
     */
    @Test
    public void testCrudRepositoryFindAll() {
        List<User> list = (List<User>) this.userRepositoryCrudRepository.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * CrudRepository 测试
     */
    @Test
    public void testCrudRepositoryDeleteById() {
        this.userRepositoryCrudRepository.deleteById(4);
    }
}
