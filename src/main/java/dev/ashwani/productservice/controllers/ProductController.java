package dev.ashwani.productservice.controllers;
import dev.ashwani.productservice.dto.GenericProductDto;
import dev.ashwani.productservice.exceptions.NotFoundException;
import dev.ashwani.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
//   { Doesn't follow in industry
//    @Autowired
//    private ProductService productService;}
    private ProductService productService;

//    Constructor Injection this method followed in industry
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping()
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        return productService.createProduct(product);
    }

    @GetMapping()
    public List<GenericProductDto> getAllProducts() throws NotFoundException{
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id")  Long id) throws NotFoundException {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public GenericProductDto updateProductById(@RequestBody @PathVariable("id") Long id) throws NotFoundException {
        return productService.updateProductById(id, new GenericProductDto());
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id) throws NotFoundException{

        return productService.deleteProductById(id);
    }

}
