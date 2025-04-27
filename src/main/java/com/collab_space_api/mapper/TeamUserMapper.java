package com.collab_space_api.mapper;

import com.collab_space_api.entity.TeamUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamUserMapper {
    public TeamUserEntity toEntity(TeamUserEntity request) {
        if (request == null) {
            return null;
        }
        TeamUserEntity entity = new TeamUserEntity();
        updateEntityFromRequest(entity, request);
        return entity;
    }

    public void updateEntityFromRequest(TeamUserEntity entity, TeamUserEntity request) {
        if (entity == null || request == null) {
            return;
        }

        entity.setTeamId(request.getTeamId());
        entity.setUserId(request.getUserId());
        entity.setRole(request.getRole());
    }

    public TeamUserEntity toResponseDTO(TeamUserEntity entity) {
        if (entity == null) {
            return null;
        }
        TeamUserEntity response = new TeamUserEntity();
        response.setTeamId(entity.getTeamId());
        response.setUserId(entity.getUserId());
        response.setRole(entity.getRole());
        return response;
    }

    public void updateEntity(TeamUserEntity entity, TeamUserEntity request) {
        updateEntityFromRequest(entity, request);
    }
}
