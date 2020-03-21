package com.greywolf.community.Controller;

import com.greywolf.community.model.user;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class loginController {
    @Autowired
    UserService userService;
    @GetMapping("/goLogin")
    public String login(){
        return "login";
    }
    @PostMapping("/goLogin")
    @ResponseBody
    public Boolean doLogin(@RequestParam("name") String name,
                          @RequestParam("password") String password,
                          HttpServletResponse response,
                          HttpServletRequest request){
        user userData = userService.seletUser(name, password);
        if (userData !=null){
            request.getSession().setAttribute("user",userData);
            Cookie cookie = new Cookie("UserToken", userData.getToken());
//           cookie的存活时间设置为15分钟
            cookie.setMaxAge(60*30);
            response.addCookie(cookie);
            return true;
        }else {
            return false;
        }

    }
}
