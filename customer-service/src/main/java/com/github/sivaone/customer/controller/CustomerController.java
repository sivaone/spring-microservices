package com.github.sivaone.customer.controller;

import com.github.sivaone.customer.dto.AddressDto;
import com.github.sivaone.customer.model.Address;
import com.github.sivaone.customer.model.Customer;
import com.github.sivaone.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/customers")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) { //TODO: change to dto
        Customer savedCustomer = customerService.save(customer);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .build(customer.getId());

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {
        log.info("Request received to find customer by id");
        Customer customer = customerService.findBy(id);
        log.info("Request completed to find customer by id");
        return ResponseEntity.ok(customer); // TODO: change to dto
    }

    @PostMapping(path = "/{customerId}/addresses")
    public ResponseEntity<Void> addAddress(@PathVariable Long customerId, @RequestBody AddressDto addressDto) {
        Address address = addressDto.toAddressDomain();
        Address savedAddress = customerService.saveAddress(customerId, address);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .build(savedAddress.getId());

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/{customerId}/addresses/{addrId}")
    public ResponseEntity<Void> addAddress(
            @PathVariable Long customerId,
            @PathVariable Long addrId,
            @RequestBody AddressDto addressDto
    ) {
        Address address = addressDto.toAddressDomain();
        address.setId(addrId);
        customerService.saveAddress(customerId, address);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{customerId}")
    @ResponseStatus(HttpStatus.ACCEPTED) // alternate way to return http status
    public void deleteCustomer(@PathVariable Long customerId) {
        customerService.delete(customerId);
    }

    // TODO: Get customer address by type
    @GetMapping(path = "/{customerId}/addresses")
    public ResponseEntity<AddressDto> findCustomerAddressByType(
            @PathVariable Long customerId,
            @RequestParam String type
    ) {
        Address address = customerService.findAddressByType(customerId, type);
        return ResponseEntity.ok(AddressDto.fromAddressDomain(address));
    }

    // TODO: Update customer

    // TODO: Delete address
}
