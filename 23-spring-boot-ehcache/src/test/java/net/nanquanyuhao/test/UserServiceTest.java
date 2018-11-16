package net.nanquanyuhao.test;

import net.nanquanyuhao.Application;
import net.nanquanyuhao.pojo.User;
import net.nanquanyuhao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by nanquanyuhao on 2018/11/16.
 * <p>
 * UserService 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindUserById() {
        // 第一次查询
        System.out.println(this.userService.findUserById(1));

        // 第二次查询
        System.out.println(this.userService.findUserById(1));
    }

    @Test
    public void testFindUserByPage() {
        Pageable pageable = PageRequest.of(0, 2);

        // 第一次查询
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());
        // 第二次查询
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());
        // 第三次查询
        pageable = PageRequest.of(1, 2);
        System.out.println(this.userService.findUserByPage(pageable).getTotalElements());
    }

    @Test
    public void testFindAll() {
        // 第一次查询
        System.out.println(this.userService.findUserAll().size());

        User user = new User();
        user.setAddress("南京");
        user.setAge(43);
        user.setName("朱七");
        this.userService.saveUser(user);

        // 第二次查询
        System.out.println(this.userService.findUserAll().size());
    }
}
