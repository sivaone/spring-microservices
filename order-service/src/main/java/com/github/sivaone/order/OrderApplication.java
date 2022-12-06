package com.github.sivaone.order;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
@EnableFeignClients
public class OrderApplication {

    @Value("${app.name}")
    private String appName;

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }


    @GetMapping
    public Map<String, String> getAppName() {
        return Map.of("app.name", appName);
    }
}
