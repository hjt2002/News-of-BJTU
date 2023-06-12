package com.example.newsofbjtu.controller;

import com.example.newsofbjtu.bean.Comment;
import com.example.newsofbjtu.service.CommentService;
import com.example.newsofbjtu.util.JsonResult;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.core.util.InternCache;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    final
    CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService= commentService;
    }
    @PostMapping("/createComment")
    public JsonResult createComment(@RequestBody Map<String,String> map){
        int uid = Integer.parseInt(map.get("uid"));
        int nid = Integer.parseInt(map.get("nid"));
        String text = map.get("text");
        return commentService.createComment(uid,nid,text);
    }
    @PostMapping("/deleteComment")
    public JsonResult deleteComment(@RequestBody Map<String,String>map){
        int cid = Integer.parseInt(map.get("cid"));
        return commentService.deleteComment(cid);
    }
    @GetMapping("getComment")
    public JsonResult<List<Comment>>getComment(@RequestParam String nid){
        return commentService.getComment(Integer.parseInt(nid));
    }
}
