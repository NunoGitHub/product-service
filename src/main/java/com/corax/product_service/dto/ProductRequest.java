package com.corax.product_service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
//DTO stands for Data Transfer Object. DTOs are used to transfer data between processes or layers of an application. They are commonly used in microservices to represent the structure of data that will be sent or received from/to an API., and busness logic not database
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private  String name;
    private  String description;
    private BigDecimal price;
}
