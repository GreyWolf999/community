package com.greywolf.community.Controller;

import com.greywolf.community.component.cookiesSelect;
import com.greywolf.community.dbo.CommentDTO;
import com.greywolf.community.service.CommentService;
import com.greywolf.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class commentController {
    @Autowired
    CommentService commentService;
    @Autowired
    QuestionService questionService;
    @PostMapping("/doComment/{PrimyId}")
    @ResponseBody
    public String doComment(HttpServletRequest request,
                            @RequestParam("commentText") String commentText,
                            @PathVariable("PrimyId") Integer PrimyId){
        String CreatortokenByCookie = new cookiesSelect().getTokenByCookie(request);
        commentService.insertComment(commentText,CreatortokenByCookie,PrimyId);
        Integer commentCounts = questionService.getCommentCounts(PrimyId);
        commentCounts++;
        questionService.updateCommentCounts(commentCounts,PrimyId);
        return "评论成功";
    }
}
