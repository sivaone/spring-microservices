package com.github.sivaone.order.service;

import com.github.sivaone.order.client.CustomerClient;
import com.github.sivaone.order.client.ProductClient;
import com.github.sivaone.order.dto.CustomerDetailsDto;
import com.github.sivaone.order.dto.OrderDetailsDto;
import com.github.sivaone.order.dto.ProductDetailsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;

    public OrderService(CustomerClient customerClient, ProductClient productClient) {
        this.customerClient = customerClient;
        this.productClient = productClient;
    }

    public OrderDetailsDto getOrderDetails(Long orderId) {
        log.info("Get order details in service start");
        CustomerDetailsDto customer = customerClient.getCustomerById(1L);
        ProductDetailsDto product = productClient.getProductById(1L);

        OrderDetailsDto orderDetailsDto = OrderDetailsDto.builder()
                .orderId(orderId)
                .customer(customer)
                .products(List.of(product))
                .build();

        log.info("Get order details in service complete");
        return orderDetailsDto;
    }
}
