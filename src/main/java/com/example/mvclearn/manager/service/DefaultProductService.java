package com.example.mvclearn.manager.service;

import com.example.mvclearn.manager.entity.Product;
import com.example.mvclearn.manager.reposytory.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }
}
