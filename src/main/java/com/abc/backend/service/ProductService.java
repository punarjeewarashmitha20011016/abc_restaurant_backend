package com.abc.backend.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import com.abc.backend.model.Offer;
import com.abc.backend.model.Product;
import com.abc.backend.model.ProductCategory;

public interface ProductService {

    public List<ProductCategory> allProductCategory();

    public ProductCategory addProductCategory(ProductCategory productCategory);
    public Optional<ProductCategory> singleProductCategory(Long id);

    public Optional<ProductCategory> singleProductCategoryById(int categoryId);

    public ProductCategory updateProductCategory(Long id, ProductCategory productCategoryDetails);

    public void deleteProductCategory(Long id);

    public List<Product> allProduct();

    public Product addProduct(Product product, MultipartFile file) throws IOException;

    public Optional<Product> singleProduct(ObjectId id);

    public Product updateProduct(ObjectId id, Product productDetails);

    public void deleteProduct(ObjectId id);

    public List<Offer> allOffer();

    public Offer addOffer(Offer offer);
    public Optional<Offer> singleOffer(ObjectId id);

    public Offer updateOffer(ObjectId id, Offer offerDetails);

    public void deleteOffer(ObjectId id);
}
