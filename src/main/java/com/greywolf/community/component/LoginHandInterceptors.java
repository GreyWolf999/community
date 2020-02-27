package com.greywolf.community.component;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 拦截器类
* 用来进行登陆检查
* */
public class LoginHandInterceptors implements HandlerInterceptor {
    //目标方法执行之前会执行以下的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Object GitHubUser = request.getSession().getAttribute("GitHubUserCookie");
//        if (GitHubUser==null){
//            //属于未登录状态 访问其他页面 return false 表示 这个请求不放行
//            // 放行过后 我们需要指定 应该到哪个页面资源
//            request.setAttribute("msg","没有权限 请先登陆！！！");
//            request.getRequestDispatcher("/index.html").forward(request,response);
//            return false;
//        }else {
//            return true;//相反 则放行请求 会直接访问目标资源
//        }
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception { }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception { }
}
