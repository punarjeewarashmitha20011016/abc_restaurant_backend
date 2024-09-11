package com.abc.backend.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abc.backend.model.Offer;
import com.abc.backend.model.Product;
import com.abc.backend.model.ProductCategory;
import com.abc.backend.model.Restaurent;
import com.abc.backend.repository.OfferRepository;
import com.abc.backend.repository.ProductCategoryRepository;
import com.abc.backend.repository.ProductRepository;
import com.abc.backend.service.ProductService;
import com.abc.backend.util.SequenceIdGen;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    @Autowired
    private SequenceIdGen sequenceIdGen;

    public List<ProductCategory> allProductCategory() {
        return productCategoryRepository.findAll();
    }

    public ProductCategory addProductCategory(ProductCategory productCategory) {
        productCategory.setId(sequenceIdGen.generateSequence(ProductCategory.class.getSimpleName()));
        return productCategoryRepository.save(productCategory);
    }

    public Optional<ProductCategory> singleProductCategory(Long id) {
        return productCategoryRepository.findById(id);
    }

    public Optional<ProductCategory> singleProductCategoryById(int categoryId) {
        return productCategoryRepository.findByCategoryId(categoryId);
    }

    public ProductCategory updateProductCategory(Long id, ProductCategory productCategoryDetails) {
        Optional<ProductCategory> optionalProductCategory = productCategoryRepository.findById(id);
        if (optionalProductCategory.isPresent()) {
            ProductCategory productCategory = optionalProductCategory.get();
            productCategory.setCategoryName(productCategoryDetails.getCategoryName());
            productCategory.setCategoryDescription(productCategoryDetails.getCategoryDescription());
            productCategory.setCategoryImage(productCategoryDetails.getCategoryImage());
            return productCategoryRepository.save(productCategory);
        }
        return null;
    }

    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }

    // ----------------------------------------------------------------------------

    private final String UPLOAD_DIR = "C:/Users/madhusha/Downloads/uploads/"; 

    @Autowired
    private ProductRepository productRepository;

    public List<Product> allProduct() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product, MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            // Get the extension of the file
            String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

            // Rename the file to productId + extension
            String newFilename = product.getProductId() + "." + extension;
            String filePath = UPLOAD_DIR + newFilename;

            // Save the file to the specified directory
            File destinationFile = new File(filePath);
            file.transferTo(destinationFile);

            // Update the product's image field with only the extension
            product.setProductImage(extension);
        } else {
            // If no file is provided, set the image field to an empty string
            product.setProductImage("");
        }

        // Save the product to the database
        return productRepository.save(product);
    }

    public Optional<Product> singleProduct(ObjectId id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(ObjectId id, Product productDetails) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setProductName(productDetails.getProductName());
            product.setProductDescription(productDetails.getProductDescription());
            product.setProductImage(productDetails.getProductImage());
            product.setProductPrice(productDetails.getProductPrice());
            product.setProductCategory(productDetails.getProductCategory());
            product.setProductStatus(productDetails.getProductStatus());
            return productRepository.save(product);
        }
        return null;
    }

    public void deleteProduct(ObjectId id) {
        productRepository.deleteById(id);
    }

    // ----------------------------------------------------------------------------

    @Autowired
    private OfferRepository offerRepository;

    public List<Offer> allOffer() {
        return offerRepository.findAll();
    }

    public Offer addOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public Optional<Offer> singleOffer(ObjectId id) {
        return offerRepository.findById(id);
    }

    public Offer updateOffer(ObjectId id, Offer offerDetails) {
        Optional<Offer> optionalOffer = offerRepository.findById(id);
        if (optionalOffer.isPresent()) {
            Offer offer = optionalOffer.get();
            offer.setOfferId(offerDetails.getOfferId());
            offer.setOfferName(offerDetails.getOfferName());
            offer.setOfferDescription(offerDetails.getOfferDescription());
            offer.setOfferImage(offerDetails.getOfferImage());
            offer.setOfferPrice(offerDetails.getOfferPrice());
            offer.setOfferDiscount(offerDetails.getOfferDiscount());
            offer.setOfferStatus(offerDetails.getOfferStatus());
            offer.setOfferStartDate(offerDetails.getOfferStartDate());
            offer.setOfferEndDate(offerDetails.getOfferEndDate());
            offer.setOfferCategory(offerDetails.getOfferCategory());
            return offerRepository.save(offer);
        }
        return null;
    }

    public void deleteOffer(ObjectId id) {
        offerRepository.deleteById(id);
    }

}
