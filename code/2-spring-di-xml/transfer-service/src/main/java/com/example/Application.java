package com.example;

import com.example.repository.AccountRepository;
import com.example.repository.JdbcAccountRepository;
import com.example.service.TransferService;
import com.example.service.TransferServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        // init/booting
        ConfigurableApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("transfer-service.xml");

        System.out.println("-".repeat(75));

        // use
        TransferService transferService=applicationContext.getBean("transferService",TransferService.class);
        transferService.transfer(300.00,"1","2");

        // destroy
        System.out.println("-".repeat(75));


    }
}