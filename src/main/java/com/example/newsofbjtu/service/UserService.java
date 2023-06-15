package com.example.newsofbjtu.service;

import com.example.newsofbjtu.bean.User;
import com.example.newsofbjtu.dao.UserMapper;
import com.example.newsofbjtu.util.JsonResult;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    final
    UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 根据用户ID获取用户信息
    public JsonResult<User>getUserByID(int uid){
        User user = userMapper.getUserByID(uid);
        if(user != null){
            // 得到用户
            return new JsonResult<>(user);
        }else {
            return new JsonResult<>("0","用户不存在");
        }
    }
    public JsonResult<User>getUserByOpenId(String openid){
        User user = userMapper.getUserByOpenId(openid);
        if(user!=null){
            return new JsonResult<>(user);
        }else {
            return new JsonResult<>("0","用户不存在");
        }
    }
}
