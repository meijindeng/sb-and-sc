package com.coast;

import com.coast.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync//开启异步调用
@SpringBootApplication
public class SpringBootAsyncApplication {
    public static void main(String[] args) {

//        @Autowired
//        private TestService testService;

        SpringApplication.run(SpringBootAsyncApplication.class, args);
    }
}
