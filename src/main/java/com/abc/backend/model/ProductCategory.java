package com.abc.backend.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "ProductCategory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {
    @Id
    private Long id;
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryImage;
}
