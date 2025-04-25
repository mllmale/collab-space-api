package com.collab_space_api.repository;

import com.collab_space_api.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByUsername(String username);

    @Query(sort = "{ createdAt: -1 }")
    List<UserEntity> findAllOrderedByCreationDateDesc();

    @Override
    List<UserEntity> findAll();

    List<UserEntity> findByProvider(String provider);

    @Query("{ 'provider': ?0, 'role': ?1 }")
    List<UserEntity> findByProviderAndRole(String provider, String role);
}