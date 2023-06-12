package com.example.newsofbjtu.controller;

import com.example.newsofbjtu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserControllerTest {
    @Autowired
    UserService userService;
    @Test
    void getUserByID() {
        System.out.println(userService.getUserByID(1001).toString());
    }
}