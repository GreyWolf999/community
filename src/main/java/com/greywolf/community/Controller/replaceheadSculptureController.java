package com.greywolf.community.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.greywolf.community.Util.PathUtil;
import com.greywolf.community.mapper.UserData;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class replaceheadSculptureController {
    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;
    @Autowired
    ObjectMapper objectMapper;
    @PostMapping("/replaceHead")
    @ResponseBody
    public String replaceHead(@RequestParam(value="file",required=false) MultipartFile file,
                              HttpServletRequest request) throws JsonProcessingException {
        //        将文件保存在项目下的satic的images文件夹下

        Map<String,Object> map=new HashMap<>();
        if (file!=null){
            String fileName = file.getOriginalFilename();
            Cookie[] cookies = request.getCookies();
            if (cookies !=null && cookies.length>1){
                for (Cookie cookie:cookies) {
                    if (cookie.getName().equals("UserToken")){
                        userService.replaceHeadSculpture(fileName,cookie.getValue());
                        questionService.cleanCache();
                        questionService.cleanCacheByToken();
                    }
                }
            }

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
