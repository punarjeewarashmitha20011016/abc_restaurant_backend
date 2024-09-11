package com.abc.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.model.Facility;
import com.abc.backend.model.Restaurent;
import com.abc.backend.repository.FacilityRepository;
import com.abc.backend.repository.RestaurentRepository;
import com.abc.backend.service.RestaurentService;
import com.abc.backend.util.SequenceIdGen;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RestaurentServiceImpl implements RestaurentService {

    @Autowired
    private RestaurentRepository restaurentRepository;

    @Autowired
    private SequenceIdGen sequenceIdGen;

    @Override
    public List<Restaurent> allRestaurents() {
        return restaurentRepository.findAll();
    }

    @Override
    public Restaurent addRestaurent(Restaurent restaurent) {
        restaurent.setLocationId(sequenceIdGen.generateSequence(Restaurent.class.getSimpleName()));
        return restaurentRepository.save(restaurent);
    }

    @Override
    public Optional<Restaurent> singleRestaurent(Long id) {
        return restaurentRepository.findById(id);
    }

    @Override
    public Restaurent updateRestaurent(Long id, Restaurent restaurentDetails) {
        return restaurentRepository.findById(id)
                .map(restaurent -> {
                    restaurent.setLocationName(restaurentDetails.getLocationName());
                    restaurent.setLocationAddress(restaurentDetails.getLocationAddress());
                    restaurent.setLocationCity(restaurentDetails.getLocationCity());
                    restaurent.setLocationDistrict(restaurentDetails.getLocationDistrict());
                    restaurent.setLocationPhone(restaurentDetails.getLocationPhone());
                    restaurent.setLocationFacilities(restaurentDetails.getLocationFacilities());
                    return restaurentRepository.save(restaurent);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurent not found"));
    }

    @Override
    public void deleteRestaurent(Long id) {
        if (restaurentRepository.existsById(id)) {
            restaurentRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurent not found");
        }
    }

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public List<Facility> allFacilities() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility addFacility(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> singleFacility(int facilityId) {
        return facilityRepository.findByFacilityId(facilityId);
    }

    @Override
    public Facility updateFacility(int facilityId, Facility facilityDetails) {
        return facilityRepository.findByFacilityId(facilityId)
                .map(facility -> {
                    facility.setFacilityName(facilityDetails.getFacilityName());
                    facility.setFacilityDescription(facilityDetails.getFacilityDescription());
                    return facilityRepository.save(facility);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Facility not found"));
    }

    @Override
    public void deleteFacility(int facilityId) {
        if (facilityRepository.existsByFacilityId(facilityId)) {
            facilityRepository.deleteByFacilityId(facilityId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Facility not found");
        }
    }
}

