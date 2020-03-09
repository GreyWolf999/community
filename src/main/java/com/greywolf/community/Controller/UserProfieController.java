package com.greywolf.community.Controller;

import com.greywolf.community.component.cookiesSelect;
import com.greywolf.community.model.user;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserProfieController {
    @Autowired
    UserService userService;
    @GetMapping("/community/profie")
//    路径在根路径的下一级 所以在页面中引入资源的时候需要加一个“/”返回上一级
    public String goProfie(HttpServletRequest request,
                           Model model){
        String tokenByCookie = new cookiesSelect().getTokenByCookie(request);
        if (tokenByCookie != null){
            user userData = userService.selectByToken(tokenByCookie);
            userData.setAvatarurl("/"+userData.getAvatarurl());
            request.getSession().setAttribute("user",userData);
        }
        return "UserProfile";
    }
}
