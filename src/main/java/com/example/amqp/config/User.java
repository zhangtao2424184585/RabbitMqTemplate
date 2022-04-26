package com.example.amqp.config;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    private String id;

    private String username;

    private String password;

}
