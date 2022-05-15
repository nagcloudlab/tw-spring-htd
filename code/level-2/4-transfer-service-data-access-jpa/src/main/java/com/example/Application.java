package com.example;

import com.example.config.TransferserviceConfiguration;
import com.example.service.TransferService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        System.out.println("-".repeat(50));
        // init / boot
        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TransferserviceConfiguration.class);


        System.out.println("-".repeat(50));

        // use
        TransferService transferService = applicationContext.getBean(TransferService.class);
        System.out.println(transferService.getClass());
        transferService.transfer(1000.00, "2", "1");

        System.out.println("-".repeat(50));
        // destroy
        applicationContext.close();
        System.out.println("-".repeat(50));
    }
}
