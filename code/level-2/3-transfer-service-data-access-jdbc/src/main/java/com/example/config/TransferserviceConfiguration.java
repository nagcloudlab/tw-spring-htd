package com.example.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Import({
        DataSourceConfiguration.class
})
@ComponentScan(basePackages = {"com.example"})
public class TransferserviceConfiguration {


}
