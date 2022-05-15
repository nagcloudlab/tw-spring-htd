package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Service2 {

    @Transactional(
            propagation = Propagation.NESTED
    )
    public void txM2() {

    }

}


