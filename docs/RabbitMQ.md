# RabbitMQ

## 类、方法、接口、注解
### CommandLineRunner接口

- 实现在项目启动后执行的功能，添加一个model并实现CommandLineRunner接口，实现功能的代码放在实现的run方法中；
- SpringBoot在项目启动后会遍历所有实现CommandLineRunner的实体类并执行run方法，如果需要按照一定的顺序去执行，那么就需要在实体类上使用一个@Order注解（或者实现Order接口）来表明顺序。

### RabbitTemplate类

- RabbitTemplate：消息模板；
- 该类提供了丰富的发送消息的方法，包括可靠性消息投递、回调监听消息接口ConfirmCallback、返回值确认接口，ReturnCallback等等同样我们需要注入到Spring容器中，然后直接使用；
- 在与spring整合时需要实例化，但是在与Springboot整合时，只需要添加配置文件即可

### convertAndSend方法

- RabbitTemplate中convertSendAndReceive方法与convertAndSend方法的区别：
  - convertAndSend ：输出时没有顺序，不需要等待，直接运行；
  - convertAndSend(…)：使用此方法，交换机会马上把所有的信息都交给所有的消费者，消费者再自行处理，不会因为消费者处理慢而阻塞线程。
  - convertSendAndReceive ：使用此方法，只有确定消费者接收到消息，才会发送下一条信息，每条消息之间会有间隔时间；
  - convertSendAndReceive(…)：可以同步消费者。使用此方法，当确认了所有的消费者都接收成功之后，才触发另一个
  - convertSendAndReceive(…)，也就是才会接收下一条消息。RPC调用方式。

### CountDownLatch类

- countDownLatch这个类使一个线程等待其他线程各自执行完毕后再执行；
- 是通过一个计数器来实现的，计数器的初始值是线程的数量。每当一个线程执行完毕后，计数器的值就-1，当计数器的值为0时，表示所有线程都执行完毕，然后在闭锁上等待的线程就可以恢复工作了。

### @Bean注解

- 凡是子类及带属性、方法的类都注册Bean到Spring中，交给它管理；
- @Bean 用在方法上，告诉Spring容器，你可以从下面这个方法中拿到一个Bean。


## RabbitMQ五种队列

### 简单队列(queue)

- 一个生产者对应一个消费者！！！
  - 生产者将消息发送到“hello”队列。消费者从该队列接收消息。
### work模式(queue)

- 一个生产者对应多个消费者，但是只能有一个消费者获得消息！！！也就是竞争消费者模式。
- 消费者1和消费者2获取到的消息内容是不同的，也就是说同一个消息只能被一个消费者获取。
- 应用场景：效率高的消费者消费消息多。可以用来进行负载均衡。
### 广度模式(交换机)
### 路由模式
### 主题模式