package com.example;

import com.example.bill.Billing;
import com.example.bill.BillingImpl;
import com.example.config.ShopITConfiguration;
import com.example.pm.PriceMatrix;
import com.example.pm.PriceMatrix_v1;
import com.example.pm.PriceMatrix_v2;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        // inti / booting
        ConfigurableApplicationContext applicationContext=
                new AnnotationConfigApplicationContext(ShopITConfiguration.class);


        // use

        Billing billing=applicationContext.getBean("billing",Billing.class);

        List<String> cart1=List.of("1","2","3");
        double totalPrice=billing.getTotalPrice(cart1);
        System.out.println("Total price - "+totalPrice);
        System.out.println("Happy shopping");

        //destroy
        applicationContext.close();

    }
}
