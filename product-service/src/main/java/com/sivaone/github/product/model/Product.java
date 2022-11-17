package com.sivaone.github.product.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "REFERENCE_ID")
    private String referenceId;

    @Column
    private String name;

    @Column(columnDefinition = "decimal", precision = 10, scale = 2)
    private BigDecimal price;

    @Column
    private String category;

    @Column
    private String description;
}
