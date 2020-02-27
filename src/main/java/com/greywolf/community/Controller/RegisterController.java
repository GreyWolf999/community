package com.greywolf.community.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @GetMapping("/goRegister")
    public String doRegister(){
        return "Register";
    }
}
