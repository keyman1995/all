package com.micro.chen.consumer.daletou.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.micro.chen.entity.DaLeTou;

public interface DaleTouService extends IService<DaLeTou> {


    void batchProcess(String value);

}
