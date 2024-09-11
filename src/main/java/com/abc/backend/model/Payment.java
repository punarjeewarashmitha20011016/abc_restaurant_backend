package com.abc.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    private String paymentId;
    private int reservationId;
    private int customerId;
    private int totalAmount;
    private String paymentStatus;
    private String paymentTime;
    private String paymentMethod;
}
