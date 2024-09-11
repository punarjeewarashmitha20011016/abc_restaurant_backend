package com.abc.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.model.Cart;
import com.abc.backend.repository.CartRepositiry;
import com.abc.backend.service.CartService;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartRepositiry cartRepositiry;

    public List<Cart> allCart() {
        return cartRepositiry.findAll();
    }

    public Cart addCart(Cart cart) {
        return cartRepositiry.save(cart);
    }

    public List<Cart> singleCart(String customerId) {
        return cartRepositiry.findByCustomerId(customerId);
    }

    public Cart addOrUpdateCart(String customerId, String productId) {
        Optional<Cart> existingCart = cartRepositiry.findByCustomerIdAndProductId(customerId, productId);

        if (existingCart.isPresent()) {
            Cart cart = existingCart.get();
            cart.setProductQuantity(cart.getProductQuantity() + 1);
            return cartRepositiry.save(cart);
        } else {
            Cart newCart = new Cart();
            newCart.setCustomerId(customerId);
            newCart.setProductId(productId);
            newCart.setProductQuantity(1);
            return cartRepositiry.save(newCart);
        }
    }

    public Cart updateCart(ObjectId id, Cart cartDetails) {
        Optional<Cart> optionalCart = cartRepositiry.findById(id);
        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();
            cart.setCustomerId(cartDetails.getCustomerId());
            cart.setProductId(cartDetails.getProductId());
            cart.setProductQuantity(cartDetails.getProductQuantity());
            return cartRepositiry.save(cart);
        }
        return null;
    }

    public void deleteCart(ObjectId id) {
        cartRepositiry.deleteById(id);
    }
}
