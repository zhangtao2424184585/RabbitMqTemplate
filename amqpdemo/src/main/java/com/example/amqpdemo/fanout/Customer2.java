package com.example.amqpdemo.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname Customer1
 * @Description TODO
 * @Date 2020/9/15 18:13
 * @Created by zhangtao
 */
//@Component
//@RabbitListener(queues = "queue1")
public class Customer2 {
    @RabbitHandler
    public void heihei(String message){
        System.out.println("queue1:"+message);
    }
}
