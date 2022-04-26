package com.example.amqp.config;

import com.google.gson.Gson;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Classname CustomerControlelr
 * @Description TODO
 * @Date 2020/9/15 17:09
 * @Created by zhangtao
 */
@RestController
public class ProviderControlelr {
    @Resource
    private RabbitTemplate template;
    @Resource
    private UserRespository userRespository;

    @GetMapping("provider")
    public String provider() {
//        User user = new User();
//        user.setId(UUID.randomUUID().toString().replace("-", ""));
//        user.setUsername("zhangsan");
//        user.setPassword("123");
        User user = userRespository.findAll().get(0);
        String s = new Gson().toJson(user);
        template.convertAndSend("ceshitopic", "A.1", s);
        return "OK";
    }

    @GetMapping("provider1")
    public String provider1() {
        User user = userRespository.findAll().get(0);
        String s = new Gson().toJson(user);
        template.convertAndSend("ceshitopic", "A.2", s);
        return "OK";
    }
}
