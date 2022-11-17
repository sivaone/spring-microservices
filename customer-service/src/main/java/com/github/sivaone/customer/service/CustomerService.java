package com.github.sivaone.customer.service;

import com.github.sivaone.customer.model.Address;
import com.github.sivaone.customer.model.Customer;

public interface CustomerService {
    Customer save(Customer customer);

    Customer findBy(Long id);

    void delete(Long id);

    Address saveAddress(Long customerId, Address address);

    Address findAddressByType(Long customerId, String type);
}
