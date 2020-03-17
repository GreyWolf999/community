package com.greywolf.community.Controller;

import com.greywolf.community.model.question;
import com.greywolf.community.service.QuestionService;
import com.greywolf.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class updateLikeCountsController {
    public boolean status=true;
    public Integer primyId=null;
    @Autowired
    QuestionService questionService;
    @PostMapping("/updateLikeCounts")
    @ResponseBody
    public String  updateLikeCounts(@RequestParam("ID") Integer PrimyId){
        question question = questionService.selectByPrimyId(PrimyId);
        primyId=PrimyId;
        status=false;
        questionService.updateLikeCOunts(PrimyId);
        return "点赞成功";
    }
}
