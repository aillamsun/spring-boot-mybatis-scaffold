package com.scaffold.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by sungang on 2017/8/19.
 */
@SpringBootApplication
@MapperScan("com.scaffold.mapper")
@ComponentScan("com.scaffold")
public class RestApiAppMain {

    public static void main(String[] args) {
        SpringApplication.run(RestApiAppMain.class, args);
    }
}
