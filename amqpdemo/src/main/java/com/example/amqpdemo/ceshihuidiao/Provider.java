package com.example.amqpdemo.ceshihuidiao;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname Provider
 * @Description TODO
 * @Date 2020/9/16 9:51
 * @Created by zhangtao
 */
@RestController
public class Provider {
    @Resource
    private RabbitTemplate template;
    @GetMapping("provider")
    public String tets(){
        template.convertAndSend("directexchange100","","嘿嘿");
        return "ok";
    }
}
