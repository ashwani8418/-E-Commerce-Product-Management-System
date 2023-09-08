package dev.ashwani.productservice.services;
import dev.ashwani.productservice.dto.GenericProductDto;
import dev.ashwani.productservice.models.Product;
import org.springframework.stereotype.Service;

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
}
