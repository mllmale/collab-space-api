package com.collab_space_api.mapper;

import com.collab_space_api.entity.TeamEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamMapper {
    public TeamEntity toEntity(TeamEntity request) {
        if (request == null) {
            return null;
        }
        TeamEntity entity = new TeamEntity();
        updateEntityFromRequest(entity, request);
        return entity;
    }

    public void updateEntityFromRequest(TeamEntity entity, TeamEntity request) {
        if (entity == null || request == null) {
            return;
        }

        entity.setName(request.getName());
        entity.setOwnerId(request.getOwnerId());
        entity.setCrateAt(request.getCrateAt());
    }

    public TeamEntity toResponseDTO(TeamEntity entity) {
        if (entity == null) {
            return null;
        }
        TeamEntity response = new TeamEntity();
        response.setName(entity.getName());
        response.setOwnerId(entity.getOwnerId());
        response.setCrateAt(entity.getCrateAt());
        return response;
    }
    public void updateEntity(TeamEntity entity, TeamEntity request) {
        updateEntityFromRequest(entity, request);
    }
}
