package net.nanquanyuhao.test;

import net.nanquanyuhao.Application;
import net.nanquanyuhao.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by nanquanyuhao on 2018/11/16.
 *
 * UserService 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testFindUserById(){
        // 第一次查询
        System.out.println(this.userService.findUserById(1));

        // 第二次查询
        System.out.println(this.userService.findUserById(1));
    }
}
