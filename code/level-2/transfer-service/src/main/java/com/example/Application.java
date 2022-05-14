package com.example;

import com.example.config.TransferserviceConfiguration;
import com.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // init / boot
        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TransferserviceConfiguration.class);


        System.out.println("-".repeat(50));

        // use
        TransferService transferService = applicationContext.getBean(TransferService.class);
        transferService.transfer(300.00, "1", "2");


        // destroy
        applicationContext.close();

    }
}
