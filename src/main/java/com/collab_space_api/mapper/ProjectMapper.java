package com.collab_space_api.mapper;

import com.collab_space_api.dto.ProjectRequestDTO;
import com.collab_space_api.dto.ProjectResponseDTO;
import com.collab_space_api.entity.ProjectEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectMapper {
    
    public ProjectEntity toEntity(ProjectRequestDTO request) {
        if (request == null) {
            return null;
        }
        ProjectEntity entity = new ProjectEntity();
        updateEntityFromRequest(entity, request);
        return entity;
    }

    public void updateEntityFromRequest(ProjectEntity entity, ProjectRequestDTO request) {
        if (entity == null || request == null) {
            return;
        }

        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setTeamId(request.getTeamId());
        entity.setOwnerId(request.getOwnerId());

        // Definir timestamps aqui se necessário
        String currentTime = java.time.LocalDateTime.now().toString();
        if (entity.getId() == null) {
            entity.setCreatedAt(currentTime);
        }
        entity.setUpdatedAt(currentTime);

        try {
            if (request.getStatus() != null) {
                entity.setStatus(ProjectEntity.Status.valueOf(request.getStatus().toUpperCase()));
            }
            if (request.getVisibility() != null) {
                entity.setVisibility(ProjectEntity.Visibility.valueOf(request.getVisibility().toUpperCase()));
            }
            if (request.getPriority() != null) {
                entity.setPriority(ProjectEntity.Priority.valueOf(request.getPriority().toUpperCase()));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Valor inválido para enum: " + e.getMessage());
        }

        entity.setDeadline(request.getDeadline());
    }

    public ProjectResponseDTO toResponseDTO(ProjectEntity entity) {
        if (entity == null) {
            return null;
        }
        
        ProjectResponseDTO response = new ProjectResponseDTO();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setTeamId(entity.getTeamId());
        response.setOwnerId(entity.getOwnerId());
        response.setCreatedAt(entity.getCreatedAt());
        response.setUpdatedAt(entity.getUpdatedAt());
        
        if (entity.getStatus() != null) {
            response.setStatus(entity.getStatus().name());
        }
        if (entity.getVisibility() != null) {
            response.setVisibility(entity.getVisibility().name());
        }
        if (entity.getPriority() != null) {
            response.setPriority(entity.getPriority().name());
        }
        
        response.setDeadline(entity.getDeadline());
        return response;
    }

    public void updateEntity(ProjectEntity entity, ProjectRequestDTO request) {
        updateEntityFromRequest(entity, request);
    }
}