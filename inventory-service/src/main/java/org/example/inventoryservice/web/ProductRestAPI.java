package org.example.inventoryservice.web;

import org.example.inventoryservice.entites.Product;
import org.example.inventoryservice.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductRestAPI {
    private ProductRepository productRepository;

    public ProductRestAPI(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> listProducts() {
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findById(@PathVariable (name = "id")Long id) {
        return productRepository.findById(String.valueOf(id)).get();
    }
    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable (name = "id") Long id) {
        productRepository.deleteById(String.valueOf(id));
    }

}
