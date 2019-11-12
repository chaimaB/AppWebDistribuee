package com.ressourceshumaines.ressouceshumaines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RessoucesHumainesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RessoucesHumainesApplication.class, args);
    }

}
