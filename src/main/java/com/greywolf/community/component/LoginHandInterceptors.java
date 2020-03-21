package com.greywolf.community.component;


import com.greywolf.community.model.topicQuestion;
import com.greywolf.community.model.user;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.TopicService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
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
    TopicService topicService;
    @Autowired
    UserService userService;
    private boolean status;
    @Autowired
    QuestionService questionService;
    //目标方法执行之前会执行以下的方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        使用redis后cookie中多自带了一个cookie_lang=1的信息 所以在这里将长度增加1
        String tokenByCookie = new cookiesSelect().getTokenByCookie(request);
        if (tokenByCookie != null){
            user userData = userService.selectByToken(tokenByCookie);
            if (userData !=null){
                request.getSession().setAttribute("user",userData);
                status=true;//相反 则放行请求 会直接访问目标资源
            }
        }else {
            //        将热门话题数据展示
            List<topicQuestion> topicQuestion = topicService.getTopicQuestion();
            if (topicQuestion.size() != 0){
                request.setAttribute("TopicQuestion",topicQuestion);
            }else request.setAttribute("TopicQuestion",null);
            request.setAttribute("msg","您还未登陆 请先登陆！！！");
            new cookiesSelect().cleanCookieAndSession(request,response);
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
