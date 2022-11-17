package com.sivaone.github.product.service;

import com.sivaone.github.product.model.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product findById(Long id);
    List<Product> findByCategory(String category);
}
