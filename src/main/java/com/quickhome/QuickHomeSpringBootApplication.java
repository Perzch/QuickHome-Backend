package com.quickhome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.quickhome.mapper")
public class QuickHomeSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickHomeSpringBootApplication.class, args);
    }

}
