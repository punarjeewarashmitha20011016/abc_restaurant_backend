package com.abc.backend.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abc.backend.model.Offer;
import com.abc.backend.model.Product;
import com.abc.backend.model.ProductCategory;
import com.abc.backend.service.ProductService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/productCategory/allProductCategories")
    public ResponseEntity<List<ProductCategory>> getAllProductCategories() {
        return new ResponseEntity<>(productService.allProductCategory(), HttpStatus.OK);
    }

    @PostMapping("/productCategory/addProductCategory")
    public ResponseEntity<ProductCategory> addProductCategory(@RequestBody ProductCategory productCategory) {
        ProductCategory newProductCategory = productService.addProductCategory(productCategory);
        return new ResponseEntity<>(newProductCategory, HttpStatus.CREATED);
    }

    @GetMapping("/productCategory/{id}")
    public ResponseEntity<Optional<ProductCategory>> singleProductCategory(@PathVariable Long id) {
        Optional<ProductCategory> productCategory = productService.singleProductCategory(id);
        return new ResponseEntity<>(productCategory, HttpStatus.OK);
    }

    @GetMapping("/productCategory/byId/{id}")
    public ResponseEntity<Optional<ProductCategory>> singleProductCategoryById(@PathVariable int categoryId) {
        Optional<ProductCategory> productCategory = productService.singleProductCategoryById(categoryId);
        return new ResponseEntity<>(productCategory, HttpStatus.OK);
    }

    @PutMapping("/productCategory/{id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@PathVariable Long id,
            @RequestBody ProductCategory productCategoryDetails) {
        ProductCategory updatedProductCategory = productService.updateProductCategory(id, productCategoryDetails);
        if (updatedProductCategory != null) {
            return new ResponseEntity<>(updatedProductCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/productCategory/{id}")
    public ResponseEntity<Void> deleteProductCategory(@PathVariable Long id) {
        productService.deleteProductCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ------------------------------------------------------------------------------------------------------------

    @GetMapping("/product/allProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.allProduct(), HttpStatus.OK);
    }

    @PostMapping("/product/addProduct")
    public ResponseEntity<Product> addProduct(
            @RequestPart("product") Product product,
            @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
            Product newProduct = productService.addProduct(product, file);
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Optional<Product>> singleProduct(@PathVariable ObjectId id) {
        Optional<Product> product = productService.singleProduct(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable ObjectId id, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(id, productDetails);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable ObjectId id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // ------------------------------------------------------------------------------------------------------------

    @GetMapping("/offer/allOffers")
    public ResponseEntity<List<Offer>> getAlloffers() {
        return new ResponseEntity<>(productService.allOffer(), HttpStatus.OK);
    }

    @PostMapping("/offer/addOffer")
    public ResponseEntity<Offer> addOffer(@RequestBody Offer offer) {
        Offer newOffer = productService.addOffer(offer);
        return new ResponseEntity<>(newOffer, HttpStatus.CREATED);
    }

    @GetMapping("/offer/{id}")
    public ResponseEntity<Optional<Offer>> singleOffer(@PathVariable ObjectId id) {
        Optional<Offer> offer = productService.singleOffer(id);
        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    @PutMapping("/offer/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable ObjectId id, @RequestBody Offer offerDetails) {
        Offer updatedOffer = productService.updateOffer(id, offerDetails);
        if (updatedOffer != null) {
            return new ResponseEntity<>(updatedOffer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/offer/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable ObjectId id) {
        productService.deleteOffer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
