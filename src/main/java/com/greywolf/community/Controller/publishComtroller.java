package com.greywolf.community.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class publishComtroller {
    @GetMapping("/publish")
    public String goPublish(){
        return "publish";
    }
}
