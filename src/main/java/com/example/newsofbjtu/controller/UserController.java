package com.example.newsofbjtu.controller;

import com.example.newsofbjtu.bean.User;
import com.example.newsofbjtu.service.UserService;
import com.example.newsofbjtu.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/user")
public class UserController {

    final
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 获取用户
    @GetMapping
    public JsonResult<User>getUserByID(@RequestParam String uid){
        return userService.getUserByID(uid);
    }
}