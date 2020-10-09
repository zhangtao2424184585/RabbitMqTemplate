package com.example.amqpdemo.ceshihuidiao;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Classname Customer1
 * @Description TODO
 * @Date 2020/9/16 9:53
 * @Created by zhangtao
 */
@Component
@RabbitListener(queues = "queue100")
public class Customer1 {
    @RabbitHandler
    public void str(String message){
        System.out.println(message);
    }
}
