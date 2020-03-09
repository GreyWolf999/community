package com.greywolf.community.service;

import com.greywolf.community.model.user;

public interface UserService {
     user addUser(user userData, String ImageUrl);
     user seletUser(String name,String password);
     user selectByToken(String token);
     void updatePassword(String token,String password);
     void updateUsername(String token, String name);
     void updateAll(String token,String name, String password);
     user replaceHeadSculpture(String avatarUrl, String tokren);
}
