package com.greywolf.community.dbo;

import lombok.Data;

@Data
public class UserQuestionDTO {
    private String title;
    private String description;
    private String tag;
    private String gmtCreate;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private String avatarUrl;
}
