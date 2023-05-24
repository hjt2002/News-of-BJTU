package com.example.newsofbjtu.dao;

import com.example.newsofbjtu.bean.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int createComment(String cid,String uid,String nid,String text);
    // 根据某个uid和nid删除某个用户在某个文章下的评论
    int deleteComment(String cid);
    // 通过nid获取某个文章下面的所有评论
    List<Comment> getComment(String nid);
}
