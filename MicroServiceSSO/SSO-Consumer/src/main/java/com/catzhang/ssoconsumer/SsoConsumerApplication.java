package com.catzhang.ssoconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SsoConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoConsumerApplication.class, args);
    }

}
