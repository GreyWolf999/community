package com.greywolf.community.Controller;

import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
//    public String doLogout(HttpServletRequest request, HttpServletResponse response){
//        questionService.cleanCache();
//        questionService.cleanCount();
//        questionService.cleanCacheByToken();
        //移除session中的数据
        request.getSession().removeAttribute("user");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("UserToken")){
                //执行销毁cookie 到达注销的目的
                cookie.setMaxAge(0);
//                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return "注销成功 退出登陆";
    }
}
