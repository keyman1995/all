package com.micro.chen.provider.user.controller;

import com.micro.chen.provider.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("list")
    public String listUser() {
        return userService.list();
    }
}
