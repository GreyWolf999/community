package com.greywolf.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface userMapper {
    @Insert("INSERT INTO user(name,token,gmtCreate,gmtModified,avatarUrl,password) " +
            "VALUES(#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl},#{password})")
    void addUser(UserData userData);
    @Select("SELECT * FROM user WHERE name=#{name} AND password=#{password}")
    UserData selectUser(String name,String password);
    @Select("SELECT * FROM USER WHERE token=#{token}")
    UserData selectUserByToken(String token);
    @Select("SELECT * FROM user")
    List<UserData> getUser();
}
