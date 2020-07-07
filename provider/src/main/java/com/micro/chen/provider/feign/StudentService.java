package com.micro.chen.provider.feign;

import com.micro.chen.provider.feign.fallback.StudentFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-consumer", fallback = StudentFallBack.class)
public interface StudentService {

    @GetMapping("user/list")
    String list();

}
