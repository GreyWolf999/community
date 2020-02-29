package com.greywolf.community.service.serviceImpl;

import com.greywolf.community.mapper.UserData;
import com.greywolf.community.mapper.userMapper;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    userMapper userMapper;
    @Override
    public void addUser(UserData userData,String avatarUrl) {
        userData.setToken(UUID.randomUUID().toString());
        userData.setGmtCreate(System.currentTimeMillis());
        userData.setGmtModified(userData.getGmtCreate());
        userData.setAvatarUrl(avatarUrl);
        userMapper.addUser(userData);
    }

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
    public UserData selectByToken(String token) {
        try {
            UserData userData = userMapper.selectUserByToken(token);
            userData.setAvatarUrl("images/"+userData.getAvatarUrl());
            return userData;
        }catch (Exception e){
            return null;
        }
    }

}
