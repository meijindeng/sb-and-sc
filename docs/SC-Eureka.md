# SpringCloud-Eureka
- spring cloud 为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等。
- 采用Eureka作为服务注册与发现的组件。

## 创建服务注册中心

### 创建1个maven主工程

- 创建一个主Maven工程，在其pom文件引入依赖;
- 这个pom文件作为父pom文件，起到依赖版本控制的作用，其他module工程继承该pom。

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>${spring-cloud.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

### 创建2个model子工程
- 一个model工程作为服务注册中心，即Eureka Server,另一个作为服务提供者，即Eureka Client。

#### Eureka Server（服务注册中心）

- 添加依赖的时候可以选择spring cloud discovery->eureka server

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```

- 启动一个**服务注册中心**，只需要一个注解@EnableEurekaServer，这个注解需要在springboot工程的启动application类上加:

```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run( EurekaServerApplication.class, args );
    }
}
```

- eureka server的配置文件appication.yml：查看代码

  - 通过eureka.client.registerWithEureka：false和fetchRegistry：false来表明自己是一个eureka server。

- eureka server 是有界面的，启动工程,打开浏览器访问： http://localhost:8761

<img src="C:\Users\meiji\AppData\Roaming\Typora\typora-user-images\image-20210713002659387.png" alt="image-20210713002659387" style="zoom:80%;" />

- No application available 没有服务被发现，因为没有注册服务，所以没有服务被发现。

## 创建服务提供者

#### Eureka Client（服务提供者）

