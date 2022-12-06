package com.sivaone.github.product.controller;

import com.sivaone.github.product.model.Product;
import com.sivaone.github.product.service.ProductService;
import io.micrometer.core.annotation.Timed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/products")
@Timed
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.save(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("{id}")
                .build(savedProduct.getId());
        return ResponseEntity.created(uri).build();
    }


    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return ResponseEntity.ok(product);
    }

    // TODO: implement pagination
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findProducts(@RequestParam String category) {
        List<Product> products = productService.findByCategory(category);
        return ResponseEntity.ok(products);
    }
}
