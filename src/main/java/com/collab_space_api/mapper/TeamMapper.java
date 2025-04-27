package com.collab_space_api.mapper;

import com.collab_space_api.dto.TeamRequestDTO;
import com.collab_space_api.dto.TeamResponseDTO;
import com.collab_space_api.entity.TeamEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamMapper {

    // Converte um DTO de criação para uma entidade
    public TeamEntity toEntity(TeamRequestDTO request) {
        if (request == null) {
            return null;
        }
        TeamEntity entity = new TeamEntity();
        updateEntityFromRequest(entity, request);
        return entity;
    }

    // Atualiza a entidade a partir de um DTO
    public void updateEntityFromRequest(TeamEntity entity, TeamRequestDTO request) {
        if (entity == null || request == null) {
            return;
        }

        entity.setName(request.getName());
        entity.setOwnerId(request.getOwnerId());
        entity.setCreatedAt(request.getCreatedAt());  // Corrigido para setCreatedAt
    }

    // Converte uma entidade para um DTO de resposta
    public TeamResponseDTO toResponseDTO(TeamEntity entity) {
        if (entity == null) {
            return null;
        }
        TeamResponseDTO response = new TeamResponseDTO();
        response.setName(entity.getName());
        response.setOwnerId(entity.getOwnerId());
        response.setCreatedAt(entity.getCreatedAt());  // Corrigido para setCreatedAt
        return response;
    }

    // Atualiza a entidade com valores do DTO
    public void updateEntity(TeamEntity entity, TeamRequestDTO request) {
        updateEntityFromRequest(entity, request);
    }
}
