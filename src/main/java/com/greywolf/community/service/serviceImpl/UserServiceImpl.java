package com.greywolf.community.service.serviceImpl;

import com.greywolf.community.mapper.UserData;
import com.greywolf.community.mapper.userMapper;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    userMapper userMapper;
//    @Cacheable(value = "user",key = "#avatarUrl")
    @Override
    public UserData addUser(UserData userData, String avatarUrl) {
        userData.setToken(UUID.randomUUID().toString());
        userData.setGmtCreate(System.currentTimeMillis());
        userData.setGmtModified(userData.getGmtCreate());
        userData.setAvatarUrl(avatarUrl);
        userMapper.addUser(userData);
        return userData;
    }

    @Cacheable(value = "user",key = "#name")
    @Override
    public UserData seletUser(String name,String password) {
        try {
            UserData userData = userMapper.selectUser(name, password);
            userData.setAvatarUrl("images/"+userData.getAvatarUrl());
            return userData;
        }catch (Exception e){
            return null;
        }
    }
    @Override
    @Cacheable(value = "user",key = "#token")
    public UserData selectByToken(String token) {
        try {
            UserData userData = userMapper.selectUserByToken(token);
            userData.setAvatarUrl("images/"+userData.getAvatarUrl());
            return userData;
        }catch (Exception e){
            return null;
        }
    }
    @Override
    public void updatePassword(String token, String password){
        userMapper.updatePassword(token,password);
    }

    @Override
    public void updateUsername(String token, String name) {
        userMapper.updateUsername(token,name);
    }

    @Override
    public void updateAll(String token, String name,String password) {
        userMapper.updateAll(token,name,password);
    }
}
