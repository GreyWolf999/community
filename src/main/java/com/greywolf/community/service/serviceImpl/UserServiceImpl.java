package com.greywolf.community.service.serviceImpl;

import com.greywolf.community.mapper.userMapper;
import com.greywolf.community.model.user;
import com.greywolf.community.model.userExample;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    userMapper userMapper;
    @Override
    public user addUser(user userData, String avatarUrl) {
        userData.setToken(UUID.randomUUID().toString());
        userData.setGmtcreate(System.currentTimeMillis());
        userData.setGmtmodified(userData.getGmtcreate());
        userData.setAvatarurl(avatarUrl);
        userMapper.insert(userData);
        return userData;
    }
    @Override
    public user seletUser(String name,String password) {

            userExample example = new userExample();
            example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
            List<user> users = userMapper.selectByExample(example);
            if (users.size()!=0){
               user user= users.get(0);
                user.setAvatarurl("images/"+user.getAvatarurl());
             return user;
            }else return null;
    }
    @Override
//    @Cacheable(value = "user",key = "#token",sync = true)
    public user selectByToken(String token) {
        try {
            userExample example = new userExample();
            example.createCriteria().andTokenEqualTo(token);
            List<user> users = userMapper.selectByExample(example);
            user user=users.get(0);
            user.setAvatarurl("images/"+user.getAvatarurl());
            return user;
        }catch (Exception e){
            return null;
        }
    }
    @Override
    public void updatePassword(String token, String password){
        user record = new user();
        record.setPassword(password);
        userExample example = new userExample();
        example.createCriteria().andTokenEqualTo(token);
        userMapper.updateByExampleSelective(record, example);
    }

    @Override
    public void updateUsername(String token, String name) {
        user record = new user();
        record.setName(name);
        userExample example = new userExample();
        example.createCriteria().andTokenEqualTo(token);
        userMapper.updateByExampleSelective(record, example);
    }

    @Override
    public void updateAll(String token, String name,String password) {
        user record = new user();
        record.setName(name);
        record.setPassword(password);
        userExample example = new userExample();
        example.createCriteria().andTokenEqualTo(token);
        userMapper.updateByExampleSelective(record, example);
    }


    @Override
//    @CachePut(value = "user",key = "#token")
    public user replaceHeadSculpture(String avatarUrl, String token){
        user record = new user();
        record.setAvatarurl(avatarUrl);
        userExample example = new userExample();
        example.createCriteria().andTokenEqualTo(token);
        userMapper.updateByExampleSelective(record, example);
        userExample userExample = new userExample();
        userExample.createCriteria().andTokenEqualTo(token);
        List<user> users = userMapper.selectByExample(userExample);
        user user =users.get(0);
        user.setAvatarurl("images/"+user.getAvatarurl());
        return user;
    }

}
