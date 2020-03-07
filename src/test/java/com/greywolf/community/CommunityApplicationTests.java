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
    RedisTemplate<Object,UserData> UserRedisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {
        UserData userData=new UserData();
        userData.setAvatarUrl("sfsdf");
        userData.setToken("jfosjgoisdg");
        userData.setName("jfosjgoisdg");
        UserRedisTemplate.opsForValue().set("mmm",userData);
        UserData mmm = UserRedisTemplate.opsForValue().get("mmm");
        mmm.setName("111111");

    }

}
