package dev.ashwani.productservice.services;

import com.github.dockerjava.api.exception.NotFoundException;
import dev.ashwani.productservice.dto.GenericProductDto;

public interface ProductService {
    GenericProductDto getProductById(Long id) throws NotFoundException;
    GenericProductDto createProduct(GenericProductDto productDto);
}
