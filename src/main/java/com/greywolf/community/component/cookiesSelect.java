package com.greywolf.community.component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

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
}
