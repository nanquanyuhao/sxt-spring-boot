package net.nanquanyuhao;

import net.nanquanyuhao.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring Boot 启动类
 *
 * @RunWith：启动器 SpringRunner 的父类 SpringJUnit4ClassRunner：让 junit 与spring 环境进行整合
 * @SpringBootTest(classes={Application.class}) 1. 当前类为 springBoot 的测试类
 * @SpringBootTest(classes={Application.class}) 2. 加载 SpringBoot 启动类，启动 springBoot
 * <p>
 * junit 与spring 整合 @Contextconfiguartion("classpath:applicationContext.xml")
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ApplicationTests {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    public void contextLoads() {
        this.userServiceImpl.addUser();
    }

}
