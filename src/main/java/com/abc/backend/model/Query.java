package com.abc.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Ruery")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Query {
    @Id
    private String queryId;
    private String queryCustomer;
    private String queryStaff;
    private String queryText;
    private String queryTime;
}
