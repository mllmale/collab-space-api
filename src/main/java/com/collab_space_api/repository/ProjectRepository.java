package com.collab_space_api.repository;

import com.collab_space_api.entity.ProjectEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository {
    List<ProjectEntity> findByName(String name);
    List<ProjectEntity> findByOwnerId(String ownerId);
    List<ProjectEntity> findByTeamId(String teamId);
    List<ProjectEntity> findByStatus(ProjectEntity.Status status);
    List<ProjectEntity> findByVisibility(ProjectEntity.Visibility visibility);
    List<ProjectEntity> findByPriority(ProjectEntity.Priority priority);
    List<ProjectEntity> findByDeadline(String deadline);
    List<ProjectEntity> findByCreatedAt(String createdAt);
    List<ProjectEntity> findByUpdatedAt(String updatedAt);
    List<ProjectEntity> findByNameAndOwnerId(String name, String ownerId);
    List<ProjectEntity> findByNameAndTeamId(String name, String teamId);
    List<ProjectEntity> findByNameAndStatus(String name, ProjectEntity.Status status);
    List<ProjectEntity> findByNameAndVisibility(String name, ProjectEntity.Visibility visibility);
    List<ProjectEntity> findByNameAndPriority(String name, ProjectEntity.Priority priority);

}
