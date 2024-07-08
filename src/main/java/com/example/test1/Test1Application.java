package com.example.test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = {"com.example.test1"})
@EnableJpaRepositories(basePackages = {"com.example.test1.repositories"})
public class Test1Application {

    public static void main(String[] args) {
        SpringApplication.run(com.example.test1.Test1Application.class, args);
    }

}
