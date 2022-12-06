package com.github.sivaone.order.controller;

import com.github.sivaone.order.dto.OrderDetailsDto;
import com.github.sivaone.order.service.OrderService;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/orders")
@Timed
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

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

    @PreAuthorize("isAuthenticated()")
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderDetailsDto> getOrderById(@PathVariable Long id) {
        log.info("Request received for order details");
        OrderDetailsDto orderDetails = orderService.getOrderDetails(id);
        orderDetails.getProducts().get(0).setQuantity(2);
        log.info("Request completed for order details");
        return ResponseEntity.ok(orderDetails);
    }
}
