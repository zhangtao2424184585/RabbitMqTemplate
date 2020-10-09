package com.example.amqpdemo.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname Config
 * @Description TODO
 * @Date 2020/9/15 18:07
 * @Created by zhangtao
 */
//@Configuration
public class Config {
    @Bean
    public Queue queue1(){
        return new Queue("queue1");
    }
    @Bean
    public Queue queue2(){
        return new Queue("queue2");
    }
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutexchange");
    }
    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }
    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }
}
