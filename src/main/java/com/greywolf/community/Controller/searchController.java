package com.greywolf.community.Controller;

import com.greywolf.community.dbo.datalayout;
import com.greywolf.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class searchController {
    @Autowired
    QuestionService questionService;
    @PostMapping("/search")
    @ResponseBody
    public Map<String,Object> searchQuestion(@RequestParam("search") String search){
         return new datalayout().getDataLayout(questionService.getPagesBySelectedByTag(search),
                 questionService.searchSelect(search),questionService.getCountByTag(search));
    }
}
