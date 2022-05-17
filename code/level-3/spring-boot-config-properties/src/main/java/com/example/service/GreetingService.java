package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;


@Profile("dev")
@Service
public class GreetingService {

//    @Value("${app.greeting.message:hello}")
//    private String message;

    @Autowired
    private GreetingProperties greetingProperties;

    @PostConstruct
    public void init(){
        System.out.println("-".repeat(50));
        System.out.println(greetingProperties.getMessage());
        System.out.println("-".repeat(50));
    }

}
