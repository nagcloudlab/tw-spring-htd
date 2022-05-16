package com.example;

import com.example.service.TransferService;
import com.foo.FooAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@Import({
//        FooAutoConfiguration.class
//})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example"})
// -or-
//@SpringBootApplication
@EntityScan(basePackages = {"com.example.entity"})
@EnableTransactionManagement
public class Application {
    public static void main(String[] args) {

        // init / booting
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(Application.class, args);

        TransferService transferService = applicationContext.getBean(TransferService.class);
        transferService.transfer(100.00, "1", "2");

//        String fooBean = applicationContext.getBean("foo", String.class);
//        System.out.println(fooBean);


        applicationContext.close();

    }
}
