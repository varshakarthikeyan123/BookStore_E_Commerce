package com.bookstore.product_service.service;

import com.bookstore.product_service.entity.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final List<Product> products = new ArrayList<>();

    public List<Product> getAll() {
        return products;
    }

    public Product add(Product product) {
        products.add(product);
        return product;
    }
}
