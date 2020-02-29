package com.greywolf.community.service;

import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.mapper.Question;

import java.util.List;

public interface QuestionService {
    public void doPublish(Question question,String creatorToken);
    public List<UserQuestionDTO> doshow();
}
