package com.cn.springboot.controller;

import com.cn.springboot.bean.User;
import com.cn.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    UserService service;

    @RequestMapping("login")
    public User login(@RequestBody User user){
        User user1 = service.getUserByMassage(user.getUsername(), user.getPassword());
        return user1;

    }
}
