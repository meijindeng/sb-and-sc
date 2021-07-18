package com.coast.mq.worker;

import com.coast.messagingrabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Sender {
    private final static String QUEUE = "work_queue";

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnect();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE,false,false,false,null);

        String msg = "hello world_";
        for(int i=0;i<10;i++){
            String t = msg + i;
            channel.basicPublish("",QUEUE,null,t.getBytes());
        }

        channel.close();
        connection.close();
    }
}
