package com.greywolf.community.service.serviceImpl;

import com.greywolf.community.mapper.Question;
import com.greywolf.community.mapper.QuestionMapper;
import com.greywolf.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionImpl implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Override
    public void doPublish(Question question,Integer id) {
        question.setCreator(id);
        question.setGmt_creat(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_creat());
        questionMapper.create(question);
    }

}
