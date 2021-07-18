package com.coast.mq.worker;

import com.coast.messagingrabbitmq.util.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer2 {

    private final static String QUEUE_NAME = "work_queue";

    public static void main(String[] args) throws Exception{
        //1、获取连接
        Connection connection = ConnectionUtil.getConnect();
        //2、声明通道
        Channel channel = connection.createChannel();
        //3、声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //同一时刻服务器只会发送一条消息给消费者
        //channel.basicQos(1);

        //4、定义队列的消费者
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("consumer:"+new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        //5、监听队列,手动返回完成状态
        channel.basicConsume(QUEUE_NAME,false,defaultConsumer);
    }

}
