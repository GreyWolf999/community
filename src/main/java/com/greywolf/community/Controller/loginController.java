package com.greywolf.community.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/goLogin")
    public String login(){
        return "login";
    }
}
