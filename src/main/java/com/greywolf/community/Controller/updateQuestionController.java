package com.greywolf.community.Controller;

import com.greywolf.community.component.cookiesSelect;
import com.greywolf.community.model.question;
import com.greywolf.community.model.user;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;


@Controller
public class updateQuestionController {

    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;
    @GetMapping("/goUpdateQuestion")
    public String goUpdateQuestion(@RequestParam("title") String title,
                                   Model model) throws ParseException {

        question selectedQuestion = questionService.getSelectedQuestionByTitle(title);
        model.addAttribute("selectedQuestion",selectedQuestion);
        return "updateQuestion";
    }
    @PostMapping("/UpdatePublish")
    public String doUpdateQuestion(question question,
                                   HttpServletRequest request){
        questionService.updateQuestion(question.getTitle(),question.getDescription(),question.getTag());
//        questionService.cleanCacheByToken();
//        questionService.cleanCache();
        //更新成功后返回个人中心页面
        String tokenByCookie = new cookiesSelect().getTokenByCookie(request);
        if (tokenByCookie != null){
            user userData = userService.selectByToken(tokenByCookie);
            userData.setAvatarurl("/"+userData.getAvatarurl());
            request.getSession().setAttribute("user",userData);
        }
        return "UserProfile";
    }
}
