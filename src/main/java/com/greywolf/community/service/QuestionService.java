package com.greywolf.community.service;

import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.mapper.Question;
import org.springframework.cache.annotation.CacheEvict;

import java.util.List;

public interface QuestionService {
     void doPublish(Question question,String creatorToken);
     List<UserQuestionDTO> doshow(int first);
     int getCount();

    int getPages();

    List<UserQuestionDTO> getQuestionByToken(int page, String token);
     //用来清除更新了相关属性的缓存
     void cleanCache();
     void cleanCacheByToken();
     void cleanCount();
}
