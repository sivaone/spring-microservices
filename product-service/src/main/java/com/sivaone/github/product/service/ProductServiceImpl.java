package com.sivaone.github.product.service;

import com.sivaone.github.product.exception.ProductNotFoundException;
import com.sivaone.github.product.model.Product;
import com.sivaone.github.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findAllByCategory(category);
    }
}
