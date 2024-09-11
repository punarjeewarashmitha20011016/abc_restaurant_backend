package com.abc.backend.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.abc.backend.model.Cart;

public interface CartService {

    public List<Cart> allCart();

    public Cart addCart(Cart cart);

    public List<Cart> singleCart(String customerId);

    public Cart addOrUpdateCart(String customerId, String productId);

    public Cart updateCart(ObjectId id, Cart cartDetails);
    public void deleteCart(ObjectId id);
}
