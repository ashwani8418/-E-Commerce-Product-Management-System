package dev.ashwani.productservice.thirdpartyclients.productservice.fakestore;


import dev.ashwani.productservice.dto.GenericProductDto;
import dev.ashwani.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class FakeStoreProductServiceClient{


    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreApi;
    private String productBaseURL;
    private String getProductById;



    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}") String fakeStoreApi){
        this.restTemplateBuilder = restTemplateBuilder;
        this.productBaseURL = fakeStoreApi;
        this.getProductById = fakeStoreApi + "/{id}";
    }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =  restTemplate.getForEntity(getProductById, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if(fakeStoreProductDto == null){
            throw new NotFoundException("Product not found for id " + id);
        }
        return fakeStoreProductDto;
    }
    public FakeStoreProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(productBaseURL, product, FakeStoreProductDto.class);

        return response.getBody();
    }
    public List<FakeStoreProductDto> getAllProducts() throws NotFoundException{
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =  restTemplate.getForEntity(productBaseURL, FakeStoreProductDto[].class);
        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();
        if(fakeStoreProductDtos == null){
            throw new NotFoundException("No products found");
        }
        return List.of(fakeStoreProductDtos);
    }

    public FakeStoreProductDto deleteProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(productBaseURL + "/" + id, HttpMethod.DELETE, requestCallback, responseExtractor);
        if(response.getBody() == null){
            throw new NotFoundException("Product not found for id " + id);
        }
        return response.getBody();
    }


    public FakeStoreProductDto updateProductById(Long id, GenericProductDto productDto) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(productBaseURL + "/" + id, HttpMethod.PUT, requestCallback, responseExtractor);
        if(response.getBody() == null){
            throw new NotFoundException("Product not found for id " + id);
        }
        return response.getBody();
    }
}
