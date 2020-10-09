package com.example.amqpdemo.directconfig;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @Classname CustomerControlelr
 * @Description TODO
 * @Date 2020/9/15 17:09
 * @Created by zhangtao
 */
public class DirectProviderControlelr {
    @Resource
    private RabbitTemplate template;
    @GetMapping("provider")
    public void provider(){
        for (int i = 0; i < 10; i++) {
            template.convertAndSend("testdirectexchange",null,"这是Direct:"+i);

        }
    }
}
