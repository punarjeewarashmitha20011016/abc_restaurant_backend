package com.abc.backend.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.backend.model.Cart;
import com.abc.backend.service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*") 
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/allCart")
    public ResponseEntity<List<Cart>> getAllCart() {
        return new ResponseEntity<>(cartService.allCart(), HttpStatus.OK);
    }

    @PostMapping("/addCart")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
        Cart newCart = cartService.addCart(cart);
        return new ResponseEntity<>(newCart, HttpStatus.CREATED);
    }

    @GetMapping("/byCustomer/{customerId}")
    public ResponseEntity<List<Cart>> singleCart(@PathVariable String customerId) {
         List<Cart> cart = cartService.singleCart(customerId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable ObjectId id, @RequestBody Cart cartDetails) {
        Cart updatedCart = cartService.updateCart(id, cartDetails);
        if (updatedCart != null) {
            return new ResponseEntity<>(updatedCart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable ObjectId id) {
        cartService.deleteCart(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addOrUpdateCart")
    public ResponseEntity<Cart> addOrUpdateCart(@RequestParam String customerId, @RequestParam String productId) {
        Cart updatedCart = cartService.addOrUpdateCart(customerId, productId);
        return ResponseEntity.ok(updatedCart);
    }
}
