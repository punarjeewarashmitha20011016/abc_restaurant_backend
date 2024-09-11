package com.abc.backend.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.model.Product;

@Repository
public interface ProductRepository extends MongoRepository <Product, ObjectId> {

}
