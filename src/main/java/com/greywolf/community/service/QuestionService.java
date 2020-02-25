package com.greywolf.community.service;

import com.greywolf.community.mapper.Question;

public interface QuestionService {
    public void doPublish(Question question,Integer id);
}
