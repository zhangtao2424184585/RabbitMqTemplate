package com.example.amqpdemo.directconfig;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;

/**
 * @Classname Customer
 * @Description TODO
 * @Date 2020/9/15 17:18
 * @Created by zhangtao
 */
//@Component
//@RabbitListener(queues = "testqueue")
public class DirectCustomer2 {
    @RabbitHandler
    public void message (String massage){
        System.out.println("1:"+massage);
    }
}
