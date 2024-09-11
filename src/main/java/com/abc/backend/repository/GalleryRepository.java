package com.abc.backend.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.model.Gallery;

@Repository
public interface GalleryRepository extends MongoRepository <Gallery, ObjectId> {

}
