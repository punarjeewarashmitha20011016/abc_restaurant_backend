package com.abc.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Offer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offer {
    @Id
    private String id;
    private String offerId;
    private String offerName;
    private String offerDescription;
    private String offerImage;
    private int offerPrice;
    private String offerDiscount;
    private String offerStatus;
    private String offerStartDate;
    private String offerEndDate;
    private int[] offerCategory;
}
