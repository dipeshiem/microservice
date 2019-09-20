package com.training.TradeService.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "simple-jms-queue1")
    public void listener(String msg){
        System.out.println("Received Message : "+msg);
    }
}
