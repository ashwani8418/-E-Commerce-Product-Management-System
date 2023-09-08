package dev.ashwani.productservice.controllers;

import dev.ashwani.productservice.models.Product;
import dev.ashwani.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
//   { Doesn't follow in industry
//    @Autowired
//    private ProductService productService;}
    private ProductService productService;

//    Constructor Injection this method followed in industry
    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }
    @PostMapping()
    public String createProduct(){
        return "Creating a product in our database";
    }

    @GetMapping()
    public String getAllProducts(){
        return "Getting all Products Soon";
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id")  Long id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public String updateProductById(@PathVariable("id") Long id){
        return "Updating product for id " + id;
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") Long id){

        return "Deleting product for id " + id;
    }
}
