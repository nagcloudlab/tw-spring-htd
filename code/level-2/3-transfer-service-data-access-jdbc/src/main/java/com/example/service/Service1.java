package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Service1 {

    Service2 service2;

    public Service1(Service2 service2) {
        this.service2 = service2;
    }

    @Transactional
    public void txM1(){
        service2.txM2();
    }

    public void txM(){
        service2.txM2();
    }

}
