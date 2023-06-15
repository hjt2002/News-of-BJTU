package com.example.newsofbjtu.dao;

import com.example.newsofbjtu.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByID(int uid);
    User getUserByOpenId(String openid);
}
