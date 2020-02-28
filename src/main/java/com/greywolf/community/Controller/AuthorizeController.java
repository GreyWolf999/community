package com.greywolf.community.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.greywolf.community.dbo.AccessTokenDTO;
import com.greywolf.community.provide.AccessTokenProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthorizeController {
    @Value("client_id")
    private String client_id;
    @Value("client_secret")
    private String client_secret;
    @Value("redirect_uri")
    private String redirect_uri;

    @Autowired
    AccessTokenProvide accessTokenProvide;
    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,
                           @RequestParam("state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) throws JsonProcessingException {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_secret(redirect_uri);
        accessTokenDTO.setState(state);
        String accessToken = accessTokenProvide.getAccessToken(accessTokenDTO);
        System.out.println(accessToken);
//        model.addAttribute("GitHubUser",gitHubUser);
        //现在那个okHttp出现错误 先用随机数代替token作为认证标准
          int random = (int)Math.random()*10;
        System.out.println(random);
          response.addCookie(new Cookie("UserToken",String.valueOf(random)));
            request.getSession().setAttribute("user","GreyWolf");
        return "index";
    }

}
