package com.abc.backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abc.backend.model.Role;

@Repository
public interface RoleRepository extends MongoRepository <Role, Integer> {
    Optional<Role> findByRoleID(int roleID);
}
