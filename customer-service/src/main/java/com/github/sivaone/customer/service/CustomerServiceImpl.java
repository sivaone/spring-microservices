package com.github.sivaone.customer.service;

import com.github.sivaone.customer.model.Address;
import com.github.sivaone.customer.model.Customer;
import com.github.sivaone.customer.repository.AddressRepository;
import com.github.sivaone.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findBy(Long id) {
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Address saveAddress(Long customerId, Address address) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(EntityNotFoundException::new);
        address.setCustomer(customer);
        return addressRepository.save(address);
    }

    @Override
    public Address findAddressByType(Long customerId, String type) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(EntityNotFoundException::new);
        return addressRepository
                .findOptionalByCustomerAndType(customer, type)
                .orElseThrow(EntityNotFoundException::new);
    }
}
