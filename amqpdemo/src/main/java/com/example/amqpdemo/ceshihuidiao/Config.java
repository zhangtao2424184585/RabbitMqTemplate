package com.example.amqpdemo.ceshihuidiao;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname Config
 * @Description TODO
 * @Date 2020/9/16 9:42
 * @Created by zhangtao
 */
@Configuration
public class Config {
//    @Bean
//    public Queue queue1() {
//        return new Queue("queue100", false);
//    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directexchange100");
    }

//    @Bean
//    public Binding binding() {
//        return BindingBuilder.bind(queue1()).to(directExchange()).with("");
//    }

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory factory) {
        RabbitTemplate template = new RabbitTemplate();
        template.setConnectionFactory(factory);
        template.setMandatory(true);
        template.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause) -> {
            System.out.println("ConfirmCallback:     " + "相关数据：" + correlationData);
            System.out.println("ConfirmCallback:     " + "确认情况：" + ack);
            System.out.println("ConfirmCallback:     " + "原因：" + cause);

        });

//        template.setReturnCallback((Message message, int replyCode, String replyText, String exchange, String routingKey) -> {
//            System.out.println("ReturnCallback:     " + "消息：" + message);
//            System.out.println("ReturnCallback:     " + "回应码：" + replyCode);
//            System.out.println("ReturnCallback:     " + "回应信息：" + replyText);
//            System.out.println("ReturnCallback:     " + "交换机：" + exchange);
//            System.out.println("ReturnCallback:     " + "路由键：" + routingKey);
//
//        });

        template.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            System.out.println("ReturnCallback:     " + "消息：" + message);
            System.out.println("ReturnCallback:     " + "回应码：" + replyCode);
            System.out.println("ReturnCallback:     " + "回应信息：" + replyText);
            System.out.println("ReturnCallback:     " + "交换机：" + exchange);
            System.out.println("ReturnCallback:     " + "路由键：" + routingKey);
        });

        return template;
    }
}
