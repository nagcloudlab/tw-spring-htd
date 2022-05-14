package com.example.bill;

import com.example.pm.PriceMatrix;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("billing")
public class BillingImpl implements Billing {

    private final static Logger logger = Logger.getLogger("shop-it");
    private final PriceMatrix priceMatrix;

    public BillingImpl(@Qualifier("v1") PriceMatrix priceMatrix) {
        this.priceMatrix = priceMatrix;
        System.out.println(this.priceMatrix.getClass());
        logger.info("Billing component created.");
    }

    public double getTotalPrice(List<String> cart) {
        logger.info("calculating total price of a cart");
        double totalPrice = 0.0;
        for (String itemCode : cart) {
            totalPrice += priceMatrix.getPrice(itemCode);
        }
        return totalPrice;
    }

}
