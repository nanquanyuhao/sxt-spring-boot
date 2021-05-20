package net.nanquanyuhao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by nanquanyuhao on 2018/11/17.
 * <p>
 * 完成对 Redis 的整合的一些配置
 */
@Configuration
public class RedisConfig {

    /**
     * 使用 spring-boot-starter-data-redis 依赖已经具备初始化的 JedisConnectionFactory ，
     * 仅需要再创建 RedisTemplate 即可
     * 20210520 实际 RedisTemplate 也会自动创建，可看需求进行内容变更
     *
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory) {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 关联
        template.setConnectionFactory(factory);
        // 为 key 设置序列化器
        template.setKeySerializer(new StringRedisSerializer());
        // 为 value 设置序列化器
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }
}
