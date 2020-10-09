package com.example.amqpdemo.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname Config
 * @Description TODO
 * @Date 2020/9/15 17:37
 * @Created by zhangtao
 */

public class Config {
    @Bean
    public Queue queuesave(){
        return new Queue("queuesave",false);
    }
    @Bean
    public Queue queuedelete(){
        return new Queue("queuesaveanddelete",false);
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("testtopic");
    }
    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(queuesave()).to(topicExchange()).with("queue.save");
    }
    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(queuedelete()).to(topicExchange()).with("queue.#");
    }
}
