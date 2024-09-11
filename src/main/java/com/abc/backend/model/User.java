package com.abc.backend.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private int role;
}
