package com.example.pm;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("v2")
public class PriceMatrix_v2 implements PriceMatrix {
    private final static Logger logger = Logger.getLogger("shop-it");

    public PriceMatrix_v2() {
        logger.info("PriceMatrix_v2 component created");
    }

    public double getPrice(String itemCode) {
        logger.info("getting price of - " + itemCode);
        //....
        return 200.00;
    }

}
