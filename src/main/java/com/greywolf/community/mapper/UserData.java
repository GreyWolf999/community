package com.greywolf.community.mapper;
import lombok.Data;
@Data
public class UserData {
    private Long id;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
    private String password;
}
