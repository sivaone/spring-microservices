package com.github.sivaone.order.client;

import com.github.sivaone.order.dto.CustomerDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-client", url = "${app.host.customer}")
public interface CustomerClient {

    @GetMapping(path = "/v1/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDetailsDto getCustomerById(@PathVariable Long id);
}
