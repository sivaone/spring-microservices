package com.github.sivaone.order.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDetailsDto {

    private Long id;

    private String referenceId;

    private String name;

    private Integer quantity;

    private BigDecimal price;

}
