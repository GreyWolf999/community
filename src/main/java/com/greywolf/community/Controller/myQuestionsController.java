package com.greywolf.community.Controller;

import com.greywolf.community.component.cookiesSelect;
import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.dbo.datalayout;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class myQuestionsController {
    private String token=null;
    private List<UserQuestionDTO> UserQuestion=new ArrayList<>();
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;
    @GetMapping("/goMyQuestion")
    public String goMyQuestions(){
        return "/myQuestions";
    }

    @PostMapping("/myQuestionsList")
    @ResponseBody
    public Map<String, Object> showList(@RequestParam("page") int page,
                                        HttpServletRequest request){
        token=new cookiesSelect().getTokenByCookie(request);
        if (token !=null){
           UserQuestion =questionService.getQuestionByToken(page,token);
        }
        return new datalayout().getDataLayout(questionService.getPages(),UserQuestion,questionService.getCount());
    }
}
