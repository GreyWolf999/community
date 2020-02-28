package com.greywolf.community.service;

import com.greywolf.community.mapper.UserData;

public interface UserService {
    public void addUser(UserData userData,String ImageUrl);
    public UserData seletUser(String name,String password);
    public UserData selectByToken(String token);
}
