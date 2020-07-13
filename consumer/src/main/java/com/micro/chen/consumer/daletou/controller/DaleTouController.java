package com.micro.chen.consumer.daletou.controller;

import com.micro.chen.consumer.daletou.service.DaleTouService;
import com.micro.chen.http.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lottery")
public class DaleTouController {

    @Autowired
    private DaleTouService daleTouService;

    @RequestMapping("history")
    public String toHistory() {
        String result = HttpUtils.getHtmlString("https://www.lottery.gov.cn/historykj/history.jspx?_ltype=dlt");
        daleTouService.batchProcess(result);
        return "SUCCESS";
    }


}
