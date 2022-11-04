package com.xichuan.dev;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.xichuan.dev"})
@EnableAutoConfiguration
@MapperScan(basePackages={"com.xichuan.dev.mapper"})
public class XichuanApplication {

    public static void main(String[] args) {
        SpringApplication.run(XichuanApplication.class, args);
    }

}
