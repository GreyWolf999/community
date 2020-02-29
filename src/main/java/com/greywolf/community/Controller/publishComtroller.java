package com.greywolf.community.Controller;

import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.mapper.Question;
import com.greywolf.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class publishComtroller {
    private String creatorToken;
    @Autowired
    QuestionService questionService;
    @GetMapping("/publish")
    public String goPublish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String doPublish(Question question,
                            HttpServletRequest request,
                            Model model){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null && cookies.length>0){
            for (Cookie cookie:cookies
                 ) {
                if (cookie.getName().equals("UserToken")){
                    creatorToken = cookie.getValue();
                }
            }
        }
        questionService.doPublish(question,creatorToken);
        List<UserQuestionDTO> doshow = questionService.doshow();
        model.addAttribute("UserQuestion",doshow);
        return "index";
    }
}
