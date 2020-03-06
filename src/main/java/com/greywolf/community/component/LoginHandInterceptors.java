package com.greywolf.community.component;


import com.greywolf.community.dbo.UserQuestionDTO;
import com.greywolf.community.mapper.UserData;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/*
* 拦截器类
* 用来进行登陆检查
* */
@Service
public class LoginHandInterceptors implements HandlerInterceptor {
    @Autowired
    UserService userService;
    private boolean status;
    @Autowired
    QuestionService questionService;
    //目标方法执行之前会执行以下的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
//        使用redis后cookie中多自带了一个cookie_lang=1的信息 所以在这里将长度增加1
        if (cookies !=null && cookies.length>2){
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("UserToken")){
                        UserData userData = userService.selectByToken(cookie.getValue());
                        if (userData !=null){
                            request.getSession().setAttribute("user",userData);
                            status=true;//相反 则放行请求 会直接访问目标资源
                        }
                    }
                }
        }else {
//            讲数据库信息放进首页中
//            List<UserQuestionDTO> doshow = questionService.doshow(1);
//            request.setAttribute("UserQuestion",doshow);
//          System.out.println("没有cookie或者只有一个idea自带的cookie");
            request.setAttribute("msg","您还未登陆 请先登陆！！！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            status=false;
        }
       return status;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception { }
}
