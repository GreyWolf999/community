package com.greywolf.community.component;

import com.greywolf.community.model.topicQuestion;
import com.greywolf.community.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.*;
import java.util.List;

@Service
public class loginTimeOut implements HandlerInterceptor {
    @Autowired
    TopicService topicService;
    private boolean status=true;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        int maxInactiveInterval = session.getMaxInactiveInterval();
        long creationTime = session.getCreationTime();
        long lastAccessedTime = session.getLastAccessedTime();
//        System.out.println("创建时间"+creationTime);
//        System.out.println("持续时间"+maxInactiveInterval);
//        System.out.println("最新链接时间"+session.getLastAccessedTime());
        //从session获取上次链接时间
        Long operateTime = (Long)session.getAttribute("operateTime");
        if(operateTime ==null){
            session.setAttribute("operateTime",lastAccessedTime);
            status=true;
        }else{
            //计算最新链接时间和上次链接时间的差值
            int intervalTime = (int)((lastAccessedTime - operateTime)/1000);
//            System.out.println("操作的ap间隔时间："+intervalTime);
            //如果超过15分钟没有交互的话，就跳转到首页界面进行重新登陆
            if(intervalTime>60*15){
                new cookiesSelect().cleanCookieAndSession(request,response);
                //        将热门话题数据展示
                List<topicQuestion> topicQuestion = topicService.getTopicQuestion();
                if (topicQuestion.size() != 0){
                    request.setAttribute("TopicQuestion",topicQuestion);
                }else request.setAttribute("TopicQuestion",null);
                request.setAttribute("timeOut",true);
                request.getRequestDispatcher("/index.html").forward(request,response);
                session.setAttribute("operateTime",null);
                status=false;
                //更新operateTime
            }else {
               session.setAttribute("operateTime",lastAccessedTime);
            }

        }
        return status;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
