package com.greywolf.community.Controller;

import com.greywolf.community.mapper.UserData;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class personalCentralController {
    private String token;
    @Autowired
    UserService userService;
    @GetMapping("/personalCentral")
    public String goPersonalCentral(Model model,
                                    HttpServletRequest request
                                    ){
//        进行用户信息回显
        Cookie[] cookies = request.getCookies();
        if (cookies !=null && cookies.length>1){
            for (Cookie cookie:cookies) {
                if (cookie.getName().equals("UserToken")){
                    token=cookie.getValue();
                    UserData userData = userService.selectByToken(token);
                    userData.setAvatarUrl("/"+userData.getAvatarUrl());
                    model.addAttribute("userdata",userData);
                }
            }
        }
        return "personalCentral";
    }
    @PostMapping("/community/updateUser")
    @ResponseBody
    public String updateUser(@RequestParam(value = "name",defaultValue = "0") String name,
                             @RequestParam(value = "password",defaultValue = "0") String password){
        if (!name.equals("0") && !password.equals("0")){
//            密码和用户名一起修改
            userService.updateAll(token,name,password);
        }else {
            if (name.equals("0") && password.equals("0")){
//                用户名和密码都不修改
            }else {
                if (name.equals("0") && !password.equals("0")){
                    userService.updatePassword(token,password);
                }else {
                    userService.updateUsername(token,name);
                }
            }
        }
        return "恭喜您!修改成功";
    }
}
