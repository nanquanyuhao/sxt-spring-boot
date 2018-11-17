package net.nanquanyuhao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Spring Data Redis 测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 添加一个字符串
     */
    @Test
    public void contextLoads() {
        this.redisTemplate.opsForValue().set("key", "北京尚学堂");
    }

    /**
     * 获取一个字符串
     */
    @Test
    public void test() {
        String value = (String) this.redisTemplate.opsForValue().get("key");
        System.out.println(value);
    }
}
