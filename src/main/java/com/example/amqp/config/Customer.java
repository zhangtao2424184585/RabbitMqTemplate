package com.example.amqp.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Classname Customer
 * @Description TODO
 * @Date 2020/9/15 17:18
 * @Created by zhangtao
 */
@Component
@RabbitListener(queues = "queue1")
public class Customer {
    @RabbitHandler
    public void onMessage(String user, Channel channel,Message msg) throws IOException {
        System.out.println("3123123");
        long deliveryTag = msg.getMessageProperties().getDeliveryTag();
        channel.basicAck(deliveryTag, true);
    }
}
