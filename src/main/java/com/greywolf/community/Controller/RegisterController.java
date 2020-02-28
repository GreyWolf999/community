package com.greywolf.community.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greywolf.community.Util.PathUtil;
import com.greywolf.community.mapper.UserData;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
public class RegisterController {
    private String imagePath=null;
    @Autowired
    UserService userService;
    @Autowired
    ObjectMapper objectMapper;
    @GetMapping("/goRegister")
    public String goRegister(){
        return "Register";
    }
    @PostMapping("/goRegister")
    @ResponseBody
    public String doRegister(UserData userData){
        userService.addUser(userData,imagePath);
        return "注册成功";
    }
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        将文件保存在项目下的satic的images文件夹下
        Map<String,Object> map=new HashMap<>();
        if (file!=null){
            String fileName = file.getOriginalFilename();
            imagePath=fileName;
            File imageFile = new PathUtil().getImageFile();
            String absolutePath = imageFile.getAbsolutePath();
            File dest = new File(absolutePath +File.separator+ fileName);
            try {
//                spingboot的文件写入方法
                file.transferTo(dest);
            } catch (IOException e) {
            }
            map.put("code",0);
            map.put("msg","");
            map.put("data","成功");
        }else {
            map.put("code",1);
        }
        return objectMapper.writeValueAsString(map);
    }
}
