package com.collab_space_api.repository;

import com.collab_space_api.entity.TaskEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository {
    List<TaskEntity> findByProjectId(String projectId);
    List<TaskEntity> findByAssignedTo(String assignedTo);
    List<TaskEntity> findByStatus(TaskEntity.Status status);
    List<TaskEntity> findByPriority(TaskEntity.Priority priority);
    List<TaskEntity> findByDeadline(String deadline);
    List<TaskEntity> findByProjectIdAndAssignedTo(String projectId, String assignedTo);
    List<TaskEntity> findByProjectIdAndStatus(String projectId, TaskEntity.Status status);
    List<TaskEntity> findByProjectIdAndPriority(String projectId, TaskEntity.Priority priority);
    List<TaskEntity> findByName(String name);
}
