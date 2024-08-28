package com.corax.product_service.controller;

import com.corax.product_service.dto.ProductRequest;
import com.corax.product_service.dto.ProductResponse;
import com.corax.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//The ProductController class handles HTTP requests and coordinates interaction between the client and the backend service. In the context of a microservice, it exposes endpoints that can be consumed by clients or other services.
//create interface rest

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //to create a post request
    //create the endpoint
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
