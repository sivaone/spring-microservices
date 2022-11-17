package com.github.sivaone.customer.repository;

import com.github.sivaone.customer.model.Address;
import com.github.sivaone.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findOptionalByCustomerAndType(Customer customer, String type);
}
