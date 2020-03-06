package com.greywolf.community.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class checkController {
    @GetMapping("/check")
    public String gocheck(){
        return "checkQuestion";
    }
}
