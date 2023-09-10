package dev.ashwani.productservice.services;
import dev.ashwani.productservice.dto.GenericProductDto;
import dev.ashwani.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductServiceImp implements ProductService {

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto productDto) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return List.of(
                new GenericProductDto(),
                new GenericProductDto()
        );
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto productDto) {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }
}
