package com.greywolf.community;

import com.greywolf.community.mapper.UserData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;


@SpringBootTest
class CommunityApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {
        UserData userData=new UserData();
        userData.setAvatarUrl("sfsdf");
        userData.setToken("jfosjgoisdg");
        userData.setName("jfosjgoisdg");
    redisTemplate.opsForValue().set("mmm",userData);
        UserData mmm = (UserData)redisTemplate.opsForValue().get("mmm");
        mmm.setName("111111");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(mmm);
        System.out.println(msg);
    }

}
