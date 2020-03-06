package com.greywolf.community.service;

import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.mapper.Question;

import java.util.List;

public interface QuestionService {
     void doPublish(Question question,String creatorToken);
     List<UserQuestionDTO> doshow(int first);
     int getCount();
}
