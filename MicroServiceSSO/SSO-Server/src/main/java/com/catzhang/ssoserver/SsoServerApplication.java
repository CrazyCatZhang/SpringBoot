package com.catzhang.ssoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SsoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoServerApplication.class, args);
    }

}
