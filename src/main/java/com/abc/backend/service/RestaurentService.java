package com.abc.backend.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.abc.backend.model.Facility;
import com.abc.backend.model.Restaurent;

public interface RestaurentService {

    public List<Restaurent> allRestaurents();

    public Restaurent addRestaurent(Restaurent restaurent);

    public Optional<Restaurent> singleRestaurent(Long id);

    public Restaurent updateRestaurent(Long id, Restaurent restaurentDetails);

    public void deleteRestaurent(Long id);

    public List<Facility> allFacilities();

    public Facility addFacility(Facility facility);

    public Optional<Facility> singleFacility(int facilityId);

    public Facility updateFacility(int facilityId, Facility facilityDetails);

    public void deleteFacility(int facilityId);
}
