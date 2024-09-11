package com.abc.backend.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import com.abc.backend.model.ReservationProduct;

import org.bson.Document;

@ReadingConverter
public class StringToReservationProductConverter implements Converter<Document, ReservationProduct> {
    @Override
    public ReservationProduct convert(Document source) {
        ReservationProduct product = new ReservationProduct();
        product.setProductId(source.getString("productId"));
        product.setProductQuantity(source.getInteger("productQuantity"));
        return product;
    }
}