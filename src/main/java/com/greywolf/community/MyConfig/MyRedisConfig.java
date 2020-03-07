package com.greywolf.community.MyConfig;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greywolf.community.mapper.UserData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;
import java.net.UnknownHostException;
import java.time.Duration;


@Configuration
public class MyRedisConfig{
//    @Bean
//    public RedisTemplate<Object, Object> UserRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
//        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate();
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer Jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(UserData.class);
//        ObjectMapper objectMapper=new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        Jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//        redisTemplate.setDefaultSerializer(Jackson2JsonRedisSerializer);
//        return redisTemplate;
//    }
//    spring boot2.x以上配置RedisCacheManager来实现缓存序列化
@Bean
public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
    RedisSerializer<String> strSerializer = new StringRedisSerializer();
    Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);
    ObjectMapper om = new ObjectMapper();
    om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    jacksonSeial.setObjectMapper(om);
    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofDays(1))
            .serializeKeysWith(RedisSerializationContext.SerializationPair
                    .fromSerializer(strSerializer))
            .serializeValuesWith(RedisSerializationContext.SerializationPair
                    .fromSerializer(jacksonSeial))
            .disableCachingNullValues();
    RedisCacheManager cacheManager = RedisCacheManager
            .builder(redisConnectionFactory).cacheDefaults(config).build();
    return cacheManager;
}
}
