package dev.ashwani.productservice.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @PostMapping()
    public String createProduct(){
        return "Creating a product in our database";
    }

    @GetMapping()
    public String getAllProducts(){
        return "Getting all Products Soon";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id")  Long id){
        return "Getting product for id " + id;
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
