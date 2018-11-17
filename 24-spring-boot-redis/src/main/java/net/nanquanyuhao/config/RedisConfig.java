package net.nanquanyuhao.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
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

    @Autowired
    private RedisProperties redisProperties;

    /**
     * 1.完成一些链接池配置
     * 2.创建 JedisConnectionFactory：配置 redis 链接信息
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {

        RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration(redisProperties.getHost(), redisProperties.getPort());
        standaloneConfig.setDatabase(redisProperties.getDatabase());
        standaloneConfig.setPassword(redisProperties.getPassword());

        JedisConnectionFactory factory = new JedisConnectionFactory(standaloneConfig);

        GenericObjectPoolConfig genericObjectPoolConfig = factory.getPoolConfig();
        genericObjectPoolConfig.setMaxIdle(redisProperties.getJedis().getPool().getMaxIdle());
        genericObjectPoolConfig.setMinIdle(redisProperties.getJedis().getPool().getMinIdle());
        genericObjectPoolConfig.setMaxTotal(redisProperties.getJedis().getPool().getMaxActive());

        return factory;
    }

    /**
     * 3.创建RedisTemplate:用于执行Redis 操作的方法
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {

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
