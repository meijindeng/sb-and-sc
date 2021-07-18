package com.coast.mq.queue;

import com.coast.messagingrabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;
import org.springframework.amqp.rabbit.listener.BlockingQueueConsumer;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Receiver {
    private final static String QUEUE = "test_hello";
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnect();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE,false,false,false,null);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
               //super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("consumer:"+new String(body));
            }
        };

        String consumerTag = channel.basicConsume(QUEUE,false,defaultConsumer);
        System.out.println(consumerTag);

        TimeUnit.SECONDS.sleep(30);

        channel.close();
        connection.close();
    }
}

