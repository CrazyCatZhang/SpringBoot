package com.catzhang.restfulcrud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.catzhang.restfulcrud.mapper")
@SpringBootApplication
public class RestfulcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulcrudApplication.class, args);
    }

}
