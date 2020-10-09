package com.example.amqpdemo.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname Customer
 * @Description TODO
 * @Date 2020/9/15 18:02
 * @Created by zhangtao
 */
//@Component
//@RabbitListener(queues = "queuesave")
public class Customer {
    @RabbitHandler
    public void queuesave(String message){
        System.out.println("save:"+message);
    }
}
