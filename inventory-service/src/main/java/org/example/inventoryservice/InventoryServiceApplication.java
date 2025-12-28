package org.example.inventoryservice;

import org.example.inventoryservice.entites.Product;
import org.example.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static jakarta.persistence.GenerationType.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(3200)
                    .quantity(11)
                    .selected(true)
                    .build());
            productRepository.save(Product.builder()
                    .name("printer")
                    .price(1200)
                    .quantity(6)
                    .selected(false)
                    .build());
            productRepository.save(Product.builder()
                    .name("smart phone")
                    .price(3200)
                    .quantity(30)
                    .selected(true)
                    .build());

        };
    }

}
