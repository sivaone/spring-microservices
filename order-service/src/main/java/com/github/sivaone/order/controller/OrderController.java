package com.github.sivaone.order.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {

//    @PreAuthorize("hasAuthority('SCOPE_api_read')")
    @PreAuthorize("isAuthenticated()")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Long>> getOrders() {
        return ResponseEntity.ok(List.of(1234L, 5678L));
    }


    //@PreAuthorize("hasAuthority('SCOPE_api_write')")
    @PreAuthorize("isAuthenticated()")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> createOrder(@RequestBody Map<String, String> order) {
        return ResponseEntity.ok(order);
    }
}
