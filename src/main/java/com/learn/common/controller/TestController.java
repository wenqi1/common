package com.learn.common.controller;

import com.learn.common.configuration.RabbitMQSender;
import com.learn.common.entity.Result;
import com.learn.common.enums.RabbitMQEnum;
import com.learn.common.service.TestService;
import com.learn.common.util.RedissonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController extends CommonController<Result,TestService> {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @RequestMapping("t")
    public void test(){
        try {
            rabbitMQSender.send(RabbitMQEnum.TEST, "hello world", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
