package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Flux<Product> getAllProducts() {
        return Flux.fromIterable(productRepository.findAll());
    }

    public Mono<Product> getProductById(Long id) {
        return Mono.justOrEmpty(productRepository.findById(id));
    }

    public Mono<Product> createProduct(Product product) {
        return Mono.just(productRepository.save(product));
    }
}
