package com.example.amqpdemo.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname Prvider
 * @Description TODO
 * @Date 2020/9/15 18:00
 * @Created by zhangtao
 */
//@RestController
public class PrviderContrller {
    @Autowired
    private RabbitTemplate template;
    @GetMapping("provider/save")
    public String save(){
        template.convertAndSend("testtopic","queue.save","save");
        return "ok";
    }
    @GetMapping("provider/delete")
    public String delete(){
        template.convertAndSend("testtopic","queue.delete","delete");
        return "ok";
    }
}
