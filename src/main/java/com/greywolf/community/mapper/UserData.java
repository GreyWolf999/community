package com.greywolf.community.mapper;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserData implements Serializable {
    private Long id;
    private String name;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;
    private String password;
}
