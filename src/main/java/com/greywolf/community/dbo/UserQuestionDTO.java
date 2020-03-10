package com.greywolf.community.dbo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserQuestionDTO implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private String gmtCreate;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private String avatarUrl;
}
