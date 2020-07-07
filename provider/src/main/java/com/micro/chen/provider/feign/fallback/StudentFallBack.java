package com.micro.chen.provider.feign.fallback;

import com.micro.chen.provider.feign.StudentService;
import org.springframework.stereotype.Component;

@Component
public class StudentFallBack implements StudentService {

    @Override
    public String list() {
        return "服务器异常";
    }
}
