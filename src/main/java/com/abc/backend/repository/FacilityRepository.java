package com.abc.backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.model.Facility;

@Repository
public interface FacilityRepository extends MongoRepository<Facility, Integer>, DeleteFacilityRepository {
    Optional<Facility> findByFacilityId(int facilityId);
    void deleteByFacilityId(int facilityId);
    boolean existsByFacilityId(int facilityId); // Method to check if a facility exists by ID
}