package net.nanquanyuhao;

import net.nanquanyuhao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
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
    public void testGet() {
        String value = (String) this.redisTemplate.opsForValue().get("key");
        System.out.println(value);
    }

    /**
     * 添加Users对象
     */
    @Test
    public void testSetUesr() {
        User user = new User();
        user.setAge(20);
        user.setName("张三丰");
        user.setId(1);
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        this.redisTemplate.opsForValue().set("user", user);
    }

    /**
     * 取Users对象
     */
    @Test
    public void testGetUser() {
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        User user = (User) this.redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }

    /**
     * 基于JSON格式存Users对象
     */
    @Test
    public void testSetUserUseJSON() {
        User user = new User();
        user.setAge(20);
        user.setName("李四丰");
        user.setId(1);
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        this.redisTemplate.opsForValue().set("users_json", user);
    }

    /**
     * 基于JSON格式取Users对象
     */
    @Test
    public void testGetUseJSON() {
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        User user = (User) this.redisTemplate.opsForValue().get("users_json");
        System.out.println(user);
    }
}
