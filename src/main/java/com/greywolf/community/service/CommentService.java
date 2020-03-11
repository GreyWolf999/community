package com.greywolf.community.service;

import com.greywolf.community.dbo.CommentDTO;

import java.util.List;

public interface CommentService {
    void insertComment(String comment, String gmCreator, Integer tokenId);

    List<CommentDTO> getCommentDTO(Integer id);
}
