package com.abc.backend.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Restaurent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurent {
    @Id
    private Long locationId;
    private String locationName;
    private String locationAddress;
    private String locationCity;
    private String locationDistrict;
    private String locationPhone;
    private int[] locationFacilities;
}
