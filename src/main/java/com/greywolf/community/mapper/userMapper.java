package com.greywolf.community.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface userMapper {
    @Insert("INSERT INTO user(name,token,gmtCreate,gmtModified,avatarUrl,password) " +
            "VALUES(#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl},#{password})")
    public void addUser(UserData userData);
    @Select("SELECT * FROM user WHERE name=#{name} AND password=#{password}")
    public UserData selectUser(String name,String password);
    @Select("SELECT * FROM USER WHERE token=#{token}")
    public UserData selectUserByToken(String token);
}
