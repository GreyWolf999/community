package com.greywolf.community.MyConfig;

import com.greywolf.community.component.LoginHandInterceptors;
import com.greywolf.community.component.loginTimeOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Autowired
   LoginHandInterceptors loginHandInterceptors;
    @Autowired
    loginTimeOut loginTimeOut;
    //视图映射器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginHandInterceptors)
//                .addPathPatterns("/**").excludePathPatterns("/","/goRegister","/goLogin"
//        ,"https://github.com/login/oauth/authorize?client_id=Iv1.3c9d32b8aa6ffd83&redirect_uri=http://localhost:8887/callback&scope=user&state=1",
//                "/callback","/index.html","/MyCss/**","/images/**","/js/**","/go","/webjars/**","/upload");
//    }
        registry.addInterceptor(loginHandInterceptors)
                .addPathPatterns("/publish","/check","/profie");
        registry.addInterceptor(loginTimeOut).addPathPatterns("/publish","/","/goLogin","/check","/doComment","/goMyQuestion",
                "/personalCentral","/replaceHead","/updateLikeCounts","/goUpdateQuestion","/profie");
    }

}