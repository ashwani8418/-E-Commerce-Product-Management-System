package dev.ashwani.productservice.services;

import dev.ashwani.productservice.models.Product;

public interface ProductService {
    Product getProductById(Long id);
}
