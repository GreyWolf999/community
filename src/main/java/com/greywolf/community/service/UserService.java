package com.greywolf.community.service;

import com.greywolf.community.mapper.UserData;

public interface UserService {
     UserData addUser(UserData userData, String ImageUrl);
     UserData seletUser(String name,String password);
     UserData selectByToken(String token);
     void updatePassword(String token,String password);

     void updateUsername(String token, String name);

     void updateAll(String token,String name, String password);

     void replaceHeadSculpture(String avatarUrl, String tokren);
}
