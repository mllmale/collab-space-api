package com.collab_space_api.mapper;

import com.collab_space_api.dto.TeamUserRequestDTO;
import com.collab_space_api.dto.TeamUserResponseDTO;
import com.collab_space_api.entity.TeamUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
@RequiredArgsConstructor
public class TeamUserMapper {

    // Converte o DTO de requisição para a entidade
    public TeamUserEntity toEntity(TeamUserRequestDTO request) {
        if (request == null) {
            return null;
        }
        TeamUserEntity entity = new TeamUserEntity();
        updateEntityFromRequest(entity, request);
        return entity;
    }

    // Atualiza a entidade com dados do DTO
    public void updateEntityFromRequest(TeamUserEntity entity, TeamUserRequestDTO request) {
        if (entity == null || request == null) {
            return;
        }

        entity.setTeamId(request.getTeamId());
        entity.setUserId(request.getUserId());
        entity.setRole(TeamUserEntity.Role.valueOf(request.getRole()));
    }

    // Converte a entidade para o DTO de resposta
    public TeamUserResponseDTO toResponseDTO(TeamUserEntity entity) {
        if (entity == null) {
            return null;
        }
        TeamUserResponseDTO response = new TeamUserResponseDTO();
        response.setTeamId(entity.getTeamId());
        response.setUserId(entity.getUserId());
        response.setRole(String.valueOf(entity.getRole()));
        return response;
    }

    // Atualiza a entidade com dados do DTO
    public void updateEntity(TeamUserEntity entity, @Valid TeamUserRequestDTO request) {
        updateEntityFromRequest(entity, request);
    }
}
