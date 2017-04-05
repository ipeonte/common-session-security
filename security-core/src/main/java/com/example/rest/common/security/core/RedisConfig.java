package com.example.rest.common.security.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.Protocol;

/**
 * Redis Configuration component
 * 
 * @author Igor Peonte <igor.144@gmail.com>
 *
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host:" + Protocol.DEFAULT_HOST + "}")
    private String host;

    @Value("${spring.redis.port:" + Protocol.DEFAULT_PORT + "}")
    private int port;

    @Value("${spring.redis.password:}")
    private String password;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
	JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(port);
        factory.setPassword(password);
        factory.setUsePool(true);

        return factory;
    }
}
