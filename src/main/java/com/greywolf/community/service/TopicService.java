package com.greywolf.community.service;

import com.greywolf.community.model.topicQuestion;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public interface TopicService {
    @Scheduled(cron = "0 1 18 * * ?")//每天的18点整执行一次
    void topicQuestion();

    List<topicQuestion> getTopicQuestion();

    void clearTopicQuestions(Integer PrimyId);

    List<topicQuestion> selectTopicQuestions();

}
