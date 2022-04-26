package com.example.amqp.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
public class TestMapping {
    @Resource
    private UserRespository userRespository;

    @GetMapping("test")
    public void aaa() {
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUsername("zhangsan");
        user.setPassword("123");
        userRespository.save(user);
    }
}
