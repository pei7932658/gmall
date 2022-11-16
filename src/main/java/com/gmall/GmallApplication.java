package com.gmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com")
@MapperScan("com.gmall.dao")
public class GmallApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallApplication.class, args);
    }

}
