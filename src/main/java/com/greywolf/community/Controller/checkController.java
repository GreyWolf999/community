package com.greywolf.community.Controller;

import com.greywolf.community.dbo.CommentDTO;
import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.model.topicQuestion;
import com.greywolf.community.service.CommentService;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.TopicService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class checkController {
    @Autowired
    updateLikeCountsController updateLikeCountsController;
    @Autowired
    TopicService topicService;
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;
    @Autowired
    CommentService commentService;
    @GetMapping("/check")
    public String gocheck(@RequestParam("title") String title,
                          Model model){
        //        将热门话题数据展示
        List<topicQuestion> topicQuestion = topicService.getTopicQuestion();
        if (topicQuestion.size() != 0){
            model.addAttribute("TopicQuestion",topicQuestion);
        }else model.addAttribute("TopicQuestion",null);

        UserQuestionDTO questionDto = questionService.getQuestionDto(title);
        if (updateLikeCountsController.primyId == questionDto.getId()){
                model.addAttribute("likeStatus",false);
        }else {
            model.addAttribute("likeStatus",true);
        }

        Integer viewCount= questionDto.getViewCount();
        viewCount++;
        questionService.updateViewCount(viewCount,questionDto.getId());
        model.addAttribute("checkselectedQuestion",questionDto);
        List<CommentDTO> commentDTO = commentService.getCommentDTO(questionDto.getId());
        if (commentDTO.size() != 0){
            model.addAttribute("comentDtoList",commentDTO);
        }else model.addAttribute("comentDtoList",null);
        questionService.cleanCache();
        questionService.cleanCacheByToken();
        return "checkQuestion";
    }
}
