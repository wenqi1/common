package com.learn.common.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonClientConfig {
    private static final Logger logger = LoggerFactory.getLogger(RedissonClientConfig.class);

    @Autowired(required = false)
    private RedissonSingleConfig redissonSingleConfig;

    @Autowired(required = false)
    private RedissonClusterConfig redissonClusterConfig;

    @Bean
    @ConditionalOnBean(name = "redissonSingleConfig")
    public RedissonClient singleRedissonClient(){
        RedissonClient redisson = null;
        Config config = new Config();
        try {
            Class<?> clazz = Class.forName(redissonSingleConfig.getCodec());
            JsonJacksonCodec codec = (JsonJacksonCodec)clazz.newInstance();
            config.setCodec(codec);
            config.useSingleServer()
                    .setPassword(redissonSingleConfig.getPassword())
                    .setAddress(redissonSingleConfig.getAddress());

            redisson = Redisson.create(config);
        } catch (Exception e) {
            logger.error("RedissonClient初始化失败{}",e);
        }

        return redisson;
    }

    @Bean
    @ConditionalOnBean(name = "redissonClusterConfig")
    public RedissonClient clusterRedissonClient(){
        RedissonClient redisson = null;
        Config config = new Config();
        try {
            Class<?> clazz = Class.forName(redissonClusterConfig.getCodec());
            JsonJacksonCodec codec = (JsonJacksonCodec)clazz.newInstance();
            config.setCodec(codec);
            config.useClusterServers()
                    //可以用"rediss://"来启用SSL连接
                    .addNodeAddress(redissonClusterConfig.getNodeAddresses());
            redisson = Redisson.create(config);
        } catch (Exception e) {
            logger.error("RedissonClient初始化失败{}",e);
        }

        return redisson;
    }
}
