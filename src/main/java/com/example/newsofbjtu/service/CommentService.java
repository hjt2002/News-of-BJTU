package com.example.newsofbjtu.service;

import com.example.newsofbjtu.bean.Comment;
import com.example.newsofbjtu.dao.CommentMapper;
import com.example.newsofbjtu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    final
    CommentMapper commentMapper;
    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }
    public JsonResult createComment(int uid,int nid,String text){
        // 查询数据库创建自增ID
        if(commentMapper.createComment(uid,nid,text)!=0){
            return new JsonResult("1","评论创建成功");
        }else {
            return new JsonResult("0","评论创建失败");
        }
    }
    public JsonResult deleteComment(int cid){
        if(commentMapper.deleteComment(cid)!=0){
            return new JsonResult("1","评论删除成功");
        }else{
            return new JsonResult("0","评论删除失败");
        }
    }
    // 查询某篇文章下的所有评论
    public JsonResult<List<Comment>>getComment(int nid){
        List<Comment>list = commentMapper.getComment(nid);
        if(list != null){
            return new JsonResult<>(list);
        }else {
            return new JsonResult<>("0","未找到该评论");
        }
    }
}
