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

import com.abc.backend.model.Gallery;
import com.abc.backend.service.GalleryService;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin(origins = "*") 
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @GetMapping("/allGallery")
    public ResponseEntity<List<Gallery>> getAllgallery() {
        return new ResponseEntity<>(galleryService.allGallery(), HttpStatus.OK);
    }

    @PostMapping("/addgallery")
    public ResponseEntity<Gallery> addgallery(@RequestBody Gallery gallery) {
        Gallery newGallery = galleryService.addGallery(gallery);
        return new ResponseEntity<>(newGallery, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Gallery>> singleGallery(@PathVariable ObjectId id){
        Optional<Gallery> gallery = galleryService.singleGallery(id);
        return new ResponseEntity<>(gallery, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gallery> updateGallery(@PathVariable ObjectId id, @RequestBody Gallery galleryDetails) {
        Gallery updatedGallery = galleryService.updateGallery(id, galleryDetails);
        if (updatedGallery != null) {
            return new ResponseEntity<>(updatedGallery, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGallery(@PathVariable ObjectId id) {
        galleryService.deleteGallery(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
