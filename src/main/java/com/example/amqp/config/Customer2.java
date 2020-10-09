package com.example.amqp.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname Customer
 * @Description TODO
 * @Date 2020/9/15 17:18
 * @Created by zhangtao
 */
@Component
@RabbitListener(queues = "testqueue")
public class Customer2 {
    @RabbitHandler
    public void message (String massage){
        System.out.println(massage);
    }
}
