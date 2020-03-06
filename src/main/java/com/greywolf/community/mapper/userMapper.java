package com.greywolf.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    @Update("UPDATE user set password=#{password} WHERE token=#{token}")
    void updatePassword(String token,String password);
    @Update("UPDATE user set name=#{name} WHERE token=#{token}")
    void updateUsername(String token, String name);
    @Update("UPDATE user set name=#{name},password=#{password} WHERE token=#{token}")
    void updateAll(String token, String name, String password);
}
