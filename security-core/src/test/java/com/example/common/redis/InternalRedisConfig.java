package com.example.common.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.util.SocketUtils;

/**
 * Configuration for Internal Redis
 * 
 * @author Igor Peonte <igor.144@gmail.com>
 *
 */
@Configuration
public class InternalRedisConfig {
    /**
     * Find random TCP port for internal Redis
     * Use localhost as defalut host
     *
     * @return RedisConnectionFactory
     */
    @Bean
    @Primary
    public RedisConnectionFactory redisConnectionFactory() {
	JedisConnectionFactory factory = new JedisConnectionFactory();
	factory.setHostName("localhost");
	factory.setPort(SocketUtils.findAvailableTcpPort());

	return factory;
    }
}
