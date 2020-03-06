package com.greywolf.community.mapper;
import lombok.Data;

import java.io.Serializable;

@Data
public class Question implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private String creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
