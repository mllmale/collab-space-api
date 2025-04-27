package com.collab_space_api.repository;

import com.collab_space_api.entity.TeamUserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TeamUserRepository extends MongoRepository<TeamUserEntity, String> {
    // Consultas por time
    List<TeamUserEntity> findByTeamId(String teamId);
    List<TeamUserEntity> findByTeamIdAndRole(String teamId, TeamUserEntity.Role role);

    // Consultas por usuário
    List<TeamUserEntity> findByUserId(String userId);
    List<TeamUserEntity> findByUserIdAndRole(String userId, TeamUserEntity.Role role);

    // Consulta por time e usuário
    Optional<TeamUserEntity> findFirstByTeamIdAndUserId(String teamId, String userId);

    // Consultas por role
    @Query("{'role': ?0}")
    List<TeamUserEntity> findByRole(TeamUserEntity.Role role);

    List <TeamUserEntity> findAllByTeamId(String teamId);
}
