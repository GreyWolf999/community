package com.greywolf.community.service.serviceImpl;

import com.greywolf.community.dbo.CommentDTO;
import com.greywolf.community.mapper.commentsMapper;
import com.greywolf.community.model.comments;
import com.greywolf.community.model.commentsExample;
import com.greywolf.community.model.user;
import com.greywolf.community.service.CommentService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    commentsMapper commentsMapper;
    @Autowired
    UserService userService;
    @Override
    public void insertComment(String comment, String gmCreator, Integer tokenId){
        comments record = new comments();
        record.setComment(comment);
        record.setCreator(gmCreator);
        record.setGmcreatc(System.currentTimeMillis());
        record.setLikencount(0);
        record.setComwhoid(tokenId);
        commentsMapper.insert(record);
    }
    @Override
    public List<CommentDTO> getCommentDTO(Integer id){
        commentsExample example = new commentsExample();
        example.createCriteria().andComwhoidEqualTo(id);
        example.setOrderByClause("gmcreatc DESC");
        List<comments> comments = commentsMapper.selectByExample(example);
        List<CommentDTO> commentDTOS=new ArrayList<>();
        for (comments comment:comments) {
            CommentDTO commentDTO=new CommentDTO();
            user user = userService.selectByToken(comment.getCreator());
            commentDTO.setAvatarUrl(user.getAvatarurl());
            BeanUtils.copyProperties(comment,commentDTO);
            commentDTOS.add(commentDTO);
        }
        return commentDTOS;
    }
}
