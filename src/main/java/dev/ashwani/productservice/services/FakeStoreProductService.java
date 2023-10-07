package dev.ashwani.productservice.services;
import dev.ashwani.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import dev.ashwani.productservice.dto.GenericProductDto;
import dev.ashwani.productservice.exceptions.NotFoundException;
import dev.ashwani.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    FakeStoreProductServiceClient fakeStoreProductServiceClient;

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }

    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient) {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }
    public GenericProductDto createProduct(GenericProductDto product) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(product));
    }

    @Override
    public List<GenericProductDto> getAllProducts() throws NotFoundException{
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getAllProducts()) {
            genericProductDtos.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) throws NotFoundException {

        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProductById(id));
    }

    @Override

    public GenericProductDto updateProductById(Long id, GenericProductDto productDto) throws NotFoundException {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.updateProductById(id, productDto));
    }
}
