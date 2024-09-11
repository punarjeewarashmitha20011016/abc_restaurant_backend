package com.abc.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Facility")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Facility {
    @Id
    private String id;
    private int facilityId;
    private String facilityName;
    private String facilityDescription;
}
