package dev.ashwani.productservice.services;
import dev.ashwani.productservice.dto.GenericProductDto;
import dev.ashwani.productservice.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id) throws NotFoundException;
    GenericProductDto createProduct(GenericProductDto productDto);

    List<GenericProductDto> getAllProducts() throws NotFoundException;
    GenericProductDto deleteProductById(Long id) throws NotFoundException;

    GenericProductDto updateProductById(Long id, GenericProductDto productDto) throws NotFoundException;
}
