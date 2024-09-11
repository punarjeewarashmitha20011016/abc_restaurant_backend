package com.abc.backend.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.model.User;


@Repository
public interface UserRepository extends MongoRepository <User, ObjectId> {
    Optional<User> findByEmailAndPassword(String email,String password);
}

