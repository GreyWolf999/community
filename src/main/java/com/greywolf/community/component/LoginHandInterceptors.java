package com.greywolf.community.component;


import com.greywolf.community.mapper.UserData;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.UserService;
import com.greywolf.community.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 拦截器类
* 用来进行登陆检查
* */
@Service
public class LoginHandInterceptors implements HandlerInterceptor {
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;
    private boolean status;
    //目标方法执行之前会执行以下的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        questionService.doshow();
        Cookie[] cookies = request.getCookies();
        if (cookies !=null && cookies.length>1){
            System.out.println(cookies.length);
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("UserToken")){
                        System.out.println("又tokrn");
                        UserData userData = userService.selectByToken(cookie.getValue());
                        if (userData !=null){
                            request.getSession().setAttribute("user",userData);
                            status=true;//相反 则放行请求 会直接访问目标资源
                        }
                    }
                }
        }else {
//            System.out.println("没有cookie或者只有一个idea自带的cookie");
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
