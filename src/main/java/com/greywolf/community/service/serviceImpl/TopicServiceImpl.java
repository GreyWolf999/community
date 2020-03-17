package com.greywolf.community.service.serviceImpl;

import com.greywolf.community.mapper.topicQuestionMapper;
import com.greywolf.community.model.question;
import com.greywolf.community.model.topicQuestion;
import com.greywolf.community.model.topicQuestionExample;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.TopicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    topicQuestionMapper topicQuestionMapper;
    @Autowired
    QuestionService questionService;
    @Scheduled(cron = "0 0 18 * * ?")//每天的18点整执行一次
    @CacheEvict(value = "TopicQuestion",allEntries = true)
    @Override
    public void topicQuestion(){
        List<topicQuestion> topicQuestions = selectTopicQuestions();
        for (topicQuestion topicquestion:topicQuestions) {
            clearTopicQuestions(topicquestion.getId());
        }
        List<question> topicQuestion = questionService.getTopicQuestion();
        for (question question : topicQuestion) {
            topicQuestion record = new topicQuestion();
            BeanUtils.copyProperties(question,record);
            topicQuestionMapper.insert(record);
        }
    }
    @Cacheable(value = "TopicQuestion")
    @Override
    public List<topicQuestion> getTopicQuestion(){
        topicQuestionExample example = new topicQuestionExample();
        example.setOrderByClause("view_count DESC");
      return   topicQuestionMapper.selectByExample(example);
    }
    @Override
    public void clearTopicQuestions(Integer PrimyId){
        topicQuestionMapper.deleteByPrimaryKey(PrimyId);
    }
    @Override
    public List<topicQuestion> selectTopicQuestions(){
       return topicQuestionMapper.selectByExample(new topicQuestionExample());
    }
}
