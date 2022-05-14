package com.example.config;

import com.example.bill.Billing;
import com.example.bill.BillingImpl;
import com.example.pm.PriceMatrix;
import com.example.pm.PriceMatrix_v1;
import com.example.pm.PriceMatrix_v2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.example"
})
public class ShopITConfiguration {

    // bean(s)

//    @Bean
//    public PriceMatrix priceMatrixV1() {
//        return new PriceMatrix_v1();
//    }
//
//    @Bean
//    public PriceMatrix priceMatrixV2() {
//        return new PriceMatrix_v2();
//    }
//
//    @Bean
//    public Billing billing() {
//        return new BillingImpl(priceMatrixV2());
//    }


}
