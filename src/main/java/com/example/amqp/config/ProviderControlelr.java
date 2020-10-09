package com.example.amqp.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname CustomerControlelr
 * @Description TODO
 * @Date 2020/9/15 17:09
 * @Created by zhangtao
 */
@RestController
public class ProviderControlelr {
    @Resource
    private RabbitTemplate template;
    @GetMapping("provider")
    public void provider(){
        template.convertAndSend("testdirectexchange",null,"这是Direct");
    }
}
