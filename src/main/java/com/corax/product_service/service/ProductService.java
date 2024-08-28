package com.corax.product_service.service;

import com.corax.product_service.dto.ProductRequest;
import com.corax.product_service.dto.ProductResponse;
import com.corax.product_service.model.Product;
import com.corax.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

//processing of the business logic
@Service
//create the constructor for us , like the constructor of the ProductRepository
@RequiredArgsConstructor
//to add logs
@Slf4j
public class ProductService {
    //we have to save this in the database, to that we need to access the product repository
    //so we need to inject the product repository into a product service class, so we use constructor injection

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        //this is an instance of the object
        Product product = Product.builder().name(productRequest.getName()).description(productRequest.getDescription()).price(productRequest.getPrice()).build();

        //save the product inside the database
        productRepository.save(product);

        log.info("Product {} is saved", product.getId());
    }
    //get all products and return a set of instances of product response, a list
    public List<ProductResponse> getAllProducts() {
        //read all products from the database
        List<Product> products = productRepository.findAll();
        //we have to map this product in the product class
        //products.stream().map(product -> mapToProductResponse(product));
        //loop through all products
        return products.stream().map(this::mapToProductResponse).toList();
    }

    // we have a product  a transform that product in an instance of product response
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId()).name(product.getName()).description(product.getDescription()).price(product.getPrice()).build();
    }
}
