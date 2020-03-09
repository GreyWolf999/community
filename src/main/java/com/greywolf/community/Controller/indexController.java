package com.greywolf.community.Controller;

import com.greywolf.community.component.cookiesSelect;
import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.dbo.datalayout;
import com.greywolf.community.model.user;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class indexController {
    Map<String,Object> map=new HashMap<>();
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;
    @PostMapping("/")
    @ResponseBody
    public Map<String, Object> index(@RequestParam("page") int page){

    List<UserQuestionDTO> UserQuestion = questionService.doshow(Integer.valueOf(page));
    return new datalayout().getDataLayout(questionService.getPages(),UserQuestion,questionService.getCount());
   }
   @GetMapping("/")
   public String goIndex(HttpServletRequest request){
       String tokenByCookie = new cookiesSelect().getTokenByCookie(request);
       if (tokenByCookie !=null){
           user userData = userService.selectByToken(tokenByCookie);
           request.getSession().setAttribute("user",userData);
       }
       return "index";
   }
}

