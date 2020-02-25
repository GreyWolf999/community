package com.greywolf.community.Controller;

import com.greywolf.community.mapper.Question;
import com.greywolf.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class publishComtroller {
    private Integer id;
    @Autowired
    QuestionService questionService;
    @GetMapping("/publish")
    public String goPublish(){
        return "publish";
    }
    @PostMapping("/publish")
    public String doPublish(Question question,
                            HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies!=null && cookies.length>0){
            for (Cookie cookie:cookies
                 ) {
                if (cookie.getName().equals("GitHubUserCookie")){
                    id = (Integer) Integer.parseInt(cookie.getValue());
                }
            }
        }
        System.out.println(id);
        questionService.doPublish(question,id);
        return "index";
    }
}
