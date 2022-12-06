package com.github.sivaone.order.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailsDto {

    private Long orderId;
    private CustomerDetailsDto customer;
    private List<ProductDetailsDto> products;
}
