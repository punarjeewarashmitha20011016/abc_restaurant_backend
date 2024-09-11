package com.abc.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.model.Gallery;
import com.abc.backend.repository.GalleryRepository;
import com.abc.backend.service.GalleryService;

@Service
public class GalleryServiceImpl implements GalleryService{

    @Autowired
    private GalleryRepository galleryRepository;

    public List<Gallery> allGallery() {
        return galleryRepository.findAll();
    }

    public Gallery addGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    public Optional<Gallery> singleGallery(ObjectId id) {
        return galleryRepository.findById(id);
    }

    public Gallery updateGallery(ObjectId id, Gallery galleryDetails) {
        Optional<Gallery> optionalGallery = galleryRepository.findById(id);
        if (optionalGallery.isPresent()) {
            Gallery gallery = optionalGallery.get();
            gallery.setImgName(galleryDetails.getImgName());
            gallery.setImgPath(galleryDetails.getImgPath());
            gallery.setImgDescription(galleryDetails.getImgDescription());
            gallery.setImgType(galleryDetails.getImgType());
            gallery.setUploadedBy(galleryDetails.getUploadedBy());
            gallery.setUploadedDate(galleryDetails.getUploadedDate());
            return galleryRepository.save(gallery);
        }
        return null;
    }

    public void deleteGallery(ObjectId id) {
            galleryRepository.deleteById(id);
    }
    
}
