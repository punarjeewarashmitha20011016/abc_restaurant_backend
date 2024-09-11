package com.abc.backend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.abc.backend.model.Facility;

@Repository
public class DeleteFacilityRepositoryImpl implements DeleteFacilityRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void deleteByFacilityId(int facilityId) {
        Query query = new Query(Criteria.where("facilityId").is(facilityId));
        mongoTemplate.remove(query, Facility.class);
    }
}
