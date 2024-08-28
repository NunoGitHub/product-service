package com.corax.product_service.repository;

import com.corax.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

//To store the product in the database we need to create a spring data repository

public interface ProductRepository  extends MongoRepository<Product, String> {
}
