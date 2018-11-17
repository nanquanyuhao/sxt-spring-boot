package net.nanquanyuhao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by nanquanyuhao on 2018/11/17.
 * <p>
 * 完成对 Redis 的整合的一些配置
 */
@Configuration
public class RedisConfig {

    @Bean
    public JedisPoolConfig jedisPoolConfig() {

        JedisPoolConfig config = new JedisPoolConfig();
        //最大空闲数
        config.setMaxIdle(10);
        //最小空闲数
        config.setMinIdle(5);
        //最大链接数
        config.setMaxTotal(20);

        return config;
    }

    /**
     * 2.创建 JedisConnectionFactory：配置 redis 链接信息
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config) {

        JedisConnectionFactory factory = new JedisConnectionFactory();
        //关联链接池的配置对象
        factory.setPoolConfig(config);
        //配置链接Redis 的信息
        //主机地址
        factory.setHostName("27.221.114.23");
        //端口
        factory.setPort(6379);
        factory.setDatabase(14);
        factory.setPassword("1qaz@WSX2w3e$R%T");

        return factory;
    }

    /**
     * 3.创建RedisTemplate:用于执行Redis 操作的方法
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
