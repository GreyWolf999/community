package com.greywolf.community.Controller;

import com.greywolf.community.component.cookiesSelect;
import com.greywolf.community.model.question;
import com.greywolf.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


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
    public String doPublish(question question,
                            HttpServletRequest request){
        String tokenByCookie = new cookiesSelect().getTokenByCookie(request);
        if (tokenByCookie !=null){
            questionService.doPublish(question,tokenByCookie);
//            questionService.cleanCache();
//            questionService.cleanCacheByToken();
        }

        /*
        *   使用重定向来解决发布页面的刷新重复提交的问题
        * 也可以再发布页面使用异步请求再将页面重定向到首页
        *  */

        return "redirect:index.html";
    }
}
