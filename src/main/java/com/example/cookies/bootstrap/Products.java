package com.example.cookies.bootstrap;

import com.example.cookies.entity.Product;
import com.example.cookies.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * pooya mahmoodi 7/13/2021
 **/
@Component
public class Products implements CommandLineRunner {
    ProductRepository productRepository;

    public Products(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
load();
    }
    private void load(){
        Product p1=new Product();
        p1.setId(1);
        p1.setName("banana");
        p1.setPrice(12);
        productRepository.save(p1);
    }
}
