package com.collab_space_api.mapper;

import com.collab_space_api.dto.TaskRequestDTO;
import com.collab_space_api.entity.TaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper {
    public TaskEntity toEntity(TaskRequestDTO request) {
        if (request == null) {
            return null;
        }
        TaskEntity entity = new TaskEntity();
        updateEntityFromRequest(entity, request);
        return entity;
    }

    public void updateEntityFromRequest(TaskEntity entity, TaskRequestDTO request) {
        if (entity == null || request == null) {
            return;
        }

        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setStatus(TaskEntity.Status.valueOf(request.getStatus()));
        entity.setPriority(TaskEntity.Priority.valueOf(request.getPriority()));
        entity.setDeadline(request.getDeadline());
        entity.setProjectId(request.getProjectId());
        entity.setAssignedTo(request.getAssignedTo());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public TaskRequestDTO toResponseDTO(TaskEntity entity) {
        if (entity == null) {
            return null;
        }
        TaskRequestDTO response = new TaskRequestDTO();
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setStatus(entity.getStatus().name());
        response.setPriority(entity.getPriority().name());
        response.setDeadline(entity.getDeadline());
        response.setProjectId(entity.getProjectId());
        response.setAssignedTo(entity.getAssignedTo());
        response.setCreatedAt(entity.getCreatedAt());
        return response;
    }

    public void updateEntity(TaskEntity entity, TaskRequestDTO request) {
        updateEntityFromRequest(entity, request);
    }
}
