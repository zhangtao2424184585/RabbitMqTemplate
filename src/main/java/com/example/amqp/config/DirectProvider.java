package com.example.amqp.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname DirectProvider
 * @Description TODO
 * @Date 2020/9/15 17:07
 * @Created by zhangtao
 */
@Configuration
public class DirectProvider {
    @Bean
    public Queue testQueue() {
        return new Queue("testqueue", false);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("testdirectexchange");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(testQueue()).to(directExchange()).with("");
    }

    @Bean
    public Queue queue() {
        return new Queue("queue", false, false, false);
    }

    @Bean
    public Queue queue1() {
        return new Queue("queue1", false, false, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("ceshitopic");
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder.bind(queue()).to(topicExchange()).with("A.1");
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("A.2");
    }
}
