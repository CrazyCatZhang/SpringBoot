package com.catzhang.ssoprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan(basePackages = "com.catzhang.ssoprovider.mapper")
public class SsoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsoProviderApplication.class, args);
    }

}
