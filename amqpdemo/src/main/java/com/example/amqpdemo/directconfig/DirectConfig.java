package com.example.amqpdemo.directconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

/**
 * @Classname DirectProvider
 * @Description TODO
 * @Date 2020/9/15 17:07
 * @Created by zhangtao
 */
//@Configuration
public class DirectConfig {
    @Bean
    public Queue testQueue(){
        return new Queue("testqueue",false);
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("testdirectexchange");
    }
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(testQueue()).to(directExchange()).with("");
    }
}
