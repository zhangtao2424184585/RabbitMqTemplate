package com.example.amqp.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Classname Customer
 * @Description TODO
 * @Date 2020/9/15 17:18
 * @Created by zhangtao
 */
@Component
@RabbitListener(queues = "queue")
public class Customer2 {
    @RabbitHandler
    public void processHandler(String msg, Channel channel, Message message) throws IOException {
        System.out.println("我是1");
        System.out.println(msg);
        channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
    }
}
