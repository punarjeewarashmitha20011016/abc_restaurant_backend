package com.abc.backend.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.model.Cart;

@Repository
public interface CartRepositiry extends MongoRepository <Cart, ObjectId>{
    List<Cart> findByCustomerId(String customerId);
    Optional<Cart> findByCustomerIdAndProductId(String customerId, String productId);
}
