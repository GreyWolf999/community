package com.greywolf.community.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.greywolf.community.dbo.AccessTokenDTO;
import com.greywolf.community.dbo.GitHubUser;
import com.greywolf.community.provide.AccessTokenProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                           Model model) throws JsonProcessingException {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setClient_secret(redirect_uri);
        accessTokenDTO.setState(state);
        GitHubUser gitHubUser = accessTokenProvide.gitHubUser(accessTokenProvide.getAccessToken(accessTokenDTO));
        model.addAttribute("GitHubUser",gitHubUser);
        return "index";
    }


}
