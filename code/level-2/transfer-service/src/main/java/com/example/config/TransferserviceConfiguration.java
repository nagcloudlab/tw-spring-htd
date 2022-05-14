package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.PropertySources;

@Configuration
@ComponentScan(basePackages = {"com.example"})
@PropertySource("classpath:app.properties")
public class TransferserviceConfiguration {

//
//    @Bean
//    public static BFPP bfpp() {
//        return new BFPP();
//    }

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
//        PropertySourcesPlaceholderConfigurer  pspc=new PropertySourcesPlaceholderConfigurer();
//        return  pspc;
//    }

}
