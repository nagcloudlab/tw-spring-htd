package com.example.pm;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("v1")
public class PriceMatrix_v1 implements PriceMatrix{

    private final static Logger logger = Logger.getLogger("shop-it");

    public PriceMatrix_v1() {
        logger.info("PriceMatrix_v1 component created");
    }

    public double getPrice(String itemCode) {
        logger.info("getting price of - " + itemCode);
        //....
        return 100.00;
    }

}
