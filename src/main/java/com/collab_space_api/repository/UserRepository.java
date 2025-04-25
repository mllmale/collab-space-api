package com.collab_space_api.repository;

import com.collab_space_api.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserEntity, String> {
    // Custom query methods can be defined here if needed
    UserEntity findByEmail(String email);
    UserEntity findByUsername(String username);

    Optional<UserEntity> findById(String id);
}
