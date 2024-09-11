package com.abc.backend.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.model.Reservation;

@Repository
public interface ReservationRepository extends MongoRepository <Reservation, ObjectId> {
    Optional<Reservation> findByCustomerId(String customerId);
}
