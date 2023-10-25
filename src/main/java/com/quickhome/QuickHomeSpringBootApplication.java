package com.quickhome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("com.quickhome.mapper")
@EnableTransactionManagement
@RestController
public class QuickHomeSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickHomeSpringBootApplication.class, args);
    }

}
