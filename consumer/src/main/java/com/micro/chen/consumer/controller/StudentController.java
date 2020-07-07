package com.micro.chen.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @RequestMapping("user/list")
    public String list(){
        return "Hello";
    }
}
