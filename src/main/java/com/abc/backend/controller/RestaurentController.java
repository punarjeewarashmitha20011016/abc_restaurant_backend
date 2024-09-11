package com.abc.backend.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.backend.model.Facility;
import com.abc.backend.model.Restaurent;
import com.abc.backend.service.RestaurentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
public class RestaurentController {

    @Autowired
    private RestaurentService restaurentService;

    @GetMapping("/restaurent/allRestaurents/")
    public ResponseEntity<List<Restaurent>> getAllRestaurants() {
        List<Restaurent> restaurents = restaurentService.allRestaurents();
        return new ResponseEntity<>(restaurents, HttpStatus.OK);
    }



    @PostMapping("/restaurent/addRestaurent")
    public ResponseEntity<Restaurent> addRestaurent(@RequestBody Restaurent restaurent) {
        Restaurent newRestaurent = restaurentService.addRestaurent(restaurent);
        return new ResponseEntity<>(newRestaurent, HttpStatus.CREATED);
    }

    @GetMapping("/restaurent/{id}")
    public ResponseEntity<Optional<Restaurent>> singleRestaurent(@PathVariable Long id) {
        Optional<Restaurent> restaurent = restaurentService.singleRestaurent(id);
        return restaurent.isPresent() ? 
            new ResponseEntity<>(restaurent, HttpStatus.OK) : 
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/restaurent/{id}")
    public ResponseEntity<Restaurent> updateRestaurent(@PathVariable Long id,
            @RequestBody Restaurent restaurentDetails) {
        Restaurent updatedRestaurent = restaurentService.updateRestaurent(id, restaurentDetails);
        return updatedRestaurent != null ? 
            new ResponseEntity<>(updatedRestaurent, HttpStatus.OK) : 
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/restaurent/{id}")
    public ResponseEntity<Void> deleteRestaurent(@PathVariable Long id) {
        restaurentService.deleteRestaurent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // -------------------------------------------------------------------------------------------

    @GetMapping("/facility/allFacilities")
    public ResponseEntity<List<Facility>> getFacilities() {
        List<Facility> facilities = restaurentService.allFacilities();
        return new ResponseEntity<>(facilities, HttpStatus.OK);
    }

    @PostMapping("/facility/addFacility")
    public ResponseEntity<Facility> addFacility(@RequestBody Facility facility) {
        Facility newFacility = restaurentService.addFacility(facility);
        return new ResponseEntity<>(newFacility, HttpStatus.CREATED);
    }

    @GetMapping("/facility/{facilityId}")
    public ResponseEntity<Optional<Facility>> singleFacility(@PathVariable int facilityId) {
        Optional<Facility> facility = restaurentService.singleFacility(facilityId);
        return facility.isPresent() ? 
            new ResponseEntity<>(facility, HttpStatus.OK) : 
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/facility/{facilityId}")
    public ResponseEntity<Facility> updateFacility(@PathVariable int facilityId,
            @RequestBody Facility facilityDetails) {
        Facility updatedFacility = restaurentService.updateFacility(facilityId, facilityDetails);
        return updatedFacility != null ? 
            new ResponseEntity<>(updatedFacility, HttpStatus.OK) : 
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/facility/{facilityId}")
    public ResponseEntity<Void> deleteFacility(@PathVariable int facilityId) {
        restaurentService.deleteFacility(facilityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

