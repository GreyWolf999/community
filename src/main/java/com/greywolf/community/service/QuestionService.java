package com.greywolf.community.service;

import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.model.question;

import java.util.List;

public interface QuestionService {
     void doPublish(question question, String creatorToken);
     List<UserQuestionDTO> doshow(int first);
     int getCount();

    int getPages();

    List<UserQuestionDTO> getQuestionByToken(int page, String token);

    question getSelectedQuestionByTitle(String title);

    void updateQuestion(String title, String description, String tag);

    UserQuestionDTO getQuestionDto(String title);


    void updateViewCount(Integer viewCount, Integer idPrimy);

    Integer getCommentCounts(Integer PrimyId);

    void updateCommentCounts(Integer CommentCounts, Integer PrimyId);

    //用来清除更新了相关属性的缓存
     void cleanCache();
     void cleanCacheByToken();
     void cleanCount();
}
