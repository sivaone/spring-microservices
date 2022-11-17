package com.github.sivaone.customer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String type; // TODO: convert to enum

    @Column
    private String line1;

    @Column
    private String line2;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;

    @Column
    private String zipcode;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
