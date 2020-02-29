package com.greywolf.community.Controller;

import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class indexController {

    @Autowired
    QuestionService questionService;
    @GetMapping("/")
    public String index(Model model){
        List<UserQuestionDTO> doshow = questionService.doshow();
        model.addAttribute("UserQuestion",doshow);
        return "index";
    }
}
