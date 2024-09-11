package com.abc.backend.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.abc.backend.model.Gallery;

public interface GalleryService {

    public List<Gallery> allGallery();

    public Gallery addGallery(Gallery gallery);
    public Optional<Gallery> singleGallery(ObjectId id);

    public Gallery updateGallery(ObjectId id, Gallery galleryDetails);

    public void deleteGallery(ObjectId id);
}
