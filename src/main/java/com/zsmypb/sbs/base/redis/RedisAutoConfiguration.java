//package com.zsmypb.spb.base.redis;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.support.collections.RedisProperties;
//
//import java.net.UnknownHostException;
//
//@Slf4j
//@Configuration
//@ConditionalOnClass(RedisOperations.class)
//@EnableConfigurationProperties(RedisProperties.class)
////@Import({LettuceConnectionConfiguration.class, JedisConnectionConfiguration.class})
//public class RedisAutoConfiguration {
//
//    @Bean
//    @ConditionalOnMissingBean(name = "redisTemplate")
//    public RedisTemplate<Object, Object> redisTemplate(
//            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        log.info("=====================");
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean
//    public StringRedisTemplate stringRedisTemplate(
//            RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        log.info("----------------");
//        StringRedisTemplate template = new StringRedisTemplate();
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }
//}