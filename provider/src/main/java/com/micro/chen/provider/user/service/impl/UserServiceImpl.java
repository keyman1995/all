package com.micro.chen.provider.user.service.impl;

import com.micro.chen.provider.feign.StudentService;
import com.micro.chen.provider.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private StudentService userService;

    @Override
    public String list() {
        return userService.list();
    }


}
