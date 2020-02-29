package com.greywolf.community.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GitHubUserMapper {
    @Select("SELECT * FROM githubuser")
    GitHubUsers getGitHubUserByToken(String token);
}
