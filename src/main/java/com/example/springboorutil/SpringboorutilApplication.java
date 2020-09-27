package com.example.springboorutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableAutoConfiguration
public class SpringboorutilApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboorutilApplication.class, args);
    }

}
