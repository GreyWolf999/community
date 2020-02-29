package com.greywolf.community.Controller;

import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.mapper.UserData;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class indexController {
    private String Token;
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;
    @GetMapping("/")
    public String index(Model model,
                        HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies !=null && cookies.length>1){
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("UserToken")){
                    Token=cookie.getValue();
                }
            }
        }
        UserData userData = userService.selectByToken(Token);
        request.getSession().setAttribute("user",userData);
        List<UserQuestionDTO> doshow = questionService.doshow();
        model.addAttribute("UserQuestion",doshow);
        return "index";
    }
}
