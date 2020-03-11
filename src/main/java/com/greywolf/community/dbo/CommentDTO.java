package com.greywolf.community.dbo;

import lombok.Data;

@Data
public class CommentDTO {
    private Integer id;
    private String comment;
    private Long gmcreatc;
    private String creator;
    private Integer likenCount;
    private String avatarUrl;
}
