package com.coast.messagingrabbitmq;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
//创建 RabbitMQ 消息接收器
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message){
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
