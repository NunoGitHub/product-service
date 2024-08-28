package com.corax.product_service.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//we should not expose the model entities to the outside world because in the future  if we add other fields that are necessary to the business model we should not expose this two fields that are not necessary
import java.math.BigDecimal;
//this package is use to communicate to the database
//Lombok is used to simplify the creation of repetitive code, such as constructors, getter/setter methods, and a fluent builder pattern.
@Document(value = "product")
// Specifies that this class represents a MongoDB document mapped to the "product" collection.
@AllArgsConstructor
// Generates a constructor with parameters for all fields in the class.
//Allows creating a Product object by passing all fields in the constructor.
@NoArgsConstructor
// Generates a no-argument constructor.
//Allows creating a Product object without passing any parameters in the constructor.
@Builder
//Allows creating a Product object in a fluent manner, such as Product.builder().field1(value1).field2(value2).build();. meaning you can chain method calls to set the properties of the object
@Data
//generates all the standard methods needed for the class, saving time and reducing the likelihood of errors.
//like getters , setters , toString(), equals(Object obj), hashCode()
public class Product {
    @Id //to specify this is a unique identifier
    private  String id;
    private  String name;
    private  String description;
    private BigDecimal price;
}
