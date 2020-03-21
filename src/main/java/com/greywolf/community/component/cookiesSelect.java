package com.greywolf.community.component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class cookiesSelect {
    private String token=null;
   public String getTokenByCookie(HttpServletRequest request){
       Cookie[] cookies = request.getCookies();
       if (cookies !=null && cookies.length>0){
           for (Cookie cookie:cookies) {
               if (cookie.getName().equals("UserToken")){
                   token=cookie.getValue();
               }
           }
       }
       return token;
   }
   public void cleanCookieAndSession(HttpServletRequest request, HttpServletResponse response){
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
   }
}
