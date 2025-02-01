package com.example.javaspringbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication()

public class JavaSpringBootdemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(JavaSpringBootdemoApplication.class, args);
        System.out.println("Hello World!");
    }
}
