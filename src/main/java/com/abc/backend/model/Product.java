package com.abc.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private String productImage;
    private int productPrice;
    private int[] productCategory;
    private String productStatus;
}
