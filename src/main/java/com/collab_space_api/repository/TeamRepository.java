package com.collab_space_api.repository;

import com.collab_space_api.entity.TeamEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends MongoRepository<TeamEntity, String> {
    List<TeamEntity> findByName(String name);
    List<TeamEntity> findByOwnerId(String ownerId);
    Optional<TeamEntity> findByCreatedAt(String createdAt);
}
