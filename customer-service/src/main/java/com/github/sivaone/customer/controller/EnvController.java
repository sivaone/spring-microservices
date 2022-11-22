package com.github.sivaone.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cloud-env")
public class EnvController {

    @Autowired
    private Environment environment;

    @GetMapping
    public ResponseEntity<Object> getEnv() {
        String appName = environment.getProperty("app.name", String.class);
        return ResponseEntity.ok(Map.of("app.name", appName));
    }
}
