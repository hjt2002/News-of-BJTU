package com.example.newsofbjtu.controller;

import com.example.newsofbjtu.dao.CommentMapper;
import com.example.newsofbjtu.service.CommentService;
import com.example.newsofbjtu.util.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        String cid = map.get("cid");
        String uid = map.get("uid");
        String nid = map.get("nid");
        String text = map.get("text");
        return commentService.createComment(cid,uid,nid,text);
    }
    @PostMapping("/deleteComment")
    public JsonResult deleteComment(@RequestBody Map<String,String>map){
        String nid = map.get("nid");
        return commentService.getComment(nid);
    }
}
