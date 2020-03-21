package com.greywolf.community.Controller;

import com.greywolf.community.component.cookiesSelect;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class logoutController {
    /*
    * 注销功能
    * */
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;
    @GetMapping("/logout")
    @ResponseBody
    @CacheEvict(value = "user",allEntries = true )
    public String doLogout(HttpServletRequest request, HttpServletResponse response){
//        questionService.cleanCache();
//        questionService.cleanCount();
//        questionService.cleanCacheByToken();
        //移除session中的数据
        request.getSession().removeAttribute("user");
        new cookiesSelect().cleanCookieAndSession(request,response);
        return "注销成功 退出登陆";
    }
}
