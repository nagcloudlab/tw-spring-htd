package com.foo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FooAutoConfiguration {

    @Bean
    public String foo() {
        return "foo";
    }

}
