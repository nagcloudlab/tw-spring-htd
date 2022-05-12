package com.example;

import com.example.config.TransferServiceConfiguration;
import com.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        System.setProperty("spring.profiles.active","dev");

        // init/booting
        ConfigurableApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(TransferServiceConfiguration.class);
        System.out.println("-".repeat(75));

        // use
        TransferService transferService=applicationContext.getBean(TransferService.class);
        transferService.transfer(300.00,"1","2");


        // destroy
        System.out.println("-".repeat(75));
        applicationContext.close();


    }
}