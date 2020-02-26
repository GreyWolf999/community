package com.greywolf.community.MyConfig;

import com.greywolf.community.component.LoginHandInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandInterceptors()).addPathPatterns("/**").excludePathPatterns("/"
//        ,"https://github.com/login/oauth/authorize?client_id=Iv1.3c9d32b8aa6ffd83&redirect_uri=http://localhost:8887/callback&scope=user&state=1",
//                "/callback");
//    }
}