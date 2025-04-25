package com.collab_space_api.repository;

import com.collab_space_api.entity.TeamEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository {
    List<TeamEntity> findByName(String name);
    List<TeamEntity> findByOwnerId(String ownerId);
    List<TeamEntity> findByCrateAt(String crateAt);
    List<TeamEntity> findById(String id);
}
