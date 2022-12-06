package com.github.sivaone.order.client;

import com.github.sivaone.order.dto.ProductDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-client", url = "${app.host.product}")
public interface ProductClient {

    @GetMapping(path = "/v1/products/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ProductDetailsDto getProductById(@PathVariable Long id);
}
