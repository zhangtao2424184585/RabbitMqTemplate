package com.example.amqpdemo.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname ProviderController
 * @Description TODO
 * @Date 2020/9/15 18:11
 * @Created by zhangtao
 */
//@RestController
public class ProviderController {
    @Resource
    private RabbitTemplate template;
    @GetMapping("heihei")
    public String heihei(){
        template.convertAndSend("fanoutexchange","","嘿嘿");
        return "ok";
    }
}
