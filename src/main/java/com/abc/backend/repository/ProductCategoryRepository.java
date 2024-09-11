package com.abc.backend.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.model.ProductCategory;

@Repository
public interface ProductCategoryRepository extends MongoRepository <ProductCategory, Long> {
    Optional<ProductCategory> findByCategoryId(int categoryId);
}
