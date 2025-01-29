package com.example.mvclearn.manager.reposytory;

import com.example.mvclearn.manager.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
}
