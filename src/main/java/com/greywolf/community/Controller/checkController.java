package com.greywolf.community.Controller;

import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class checkController {
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;
    @GetMapping("/check")
    public String gocheck(@RequestParam("title") String title,
                          Model model){
        UserQuestionDTO questionDto = questionService.getQuestionDto(title);
        Integer viewCount= questionDto.getViewCount();
        viewCount++;
        System.out.println(questionDto.getId());
        questionService.updateViewCount(viewCount,questionDto.getId());
        model.addAttribute("checkselectedQuestion",questionDto);
        questionService.cleanCache();
        questionService.cleanCacheByToken();
        return "checkQuestion";
    }
}
