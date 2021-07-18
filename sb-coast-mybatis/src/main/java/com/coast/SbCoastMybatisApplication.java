package com.coast;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.coast.dao"})
@SpringBootApplication
public class SbCoastMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbCoastMybatisApplication.class, args);
    }

}
