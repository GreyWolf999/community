package com.greywolf.community.service.serviceImpl;

import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.mapper.Question;
import com.greywolf.community.mapper.QuestionMapper;
import com.greywolf.community.mapper.UserData;
import com.greywolf.community.mapper.userMapper;
import com.greywolf.community.service.QuestionService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QuestionImpl implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    userMapper userMapper;
    @Override
    public void doPublish(Question question,String creatorToken) {
        question.setCreator(creatorToken);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.create(question);
    }


    @Cacheable(value = "questionList")
    @Override
    public List<UserQuestionDTO> doshow(int page) {
//        自定义分页数目
        int limits=5;
        Date date=new Date();
        //        获取分页开始的数字
        int limitFirst=(page-1)*limits;
        List<UserQuestionDTO> UserQuestionlist=new ArrayList<>();
        List<Question> question = questionMapper.getQuestion(limitFirst,limits);
        for (Question UserQuestion:question) {
            UserQuestionDTO userQuestionDTO=new UserQuestionDTO();
            UserData userData = userMapper.selectUserByToken(UserQuestion.getCreator());
            userQuestionDTO.setAvatarUrl("images/"+userData.getAvatarUrl());
            //将毫秒值转化成日期
            date.setTime(UserQuestion.getGmtCreate());
            userQuestionDTO.setGmtCreate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            BeanUtils.copyProperties(UserQuestion,userQuestionDTO);
            UserQuestionlist.add(userQuestionDTO);
        }
        return UserQuestionlist;
    }
    @Cacheable(value = "count")
    @Override
    public int getCount(){
        return questionMapper.getConunt();
    }
}
