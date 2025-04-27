package com.collab_space_api.mapper;

import com.collab_space_api.dto.NotificationRequestDTO;
import com.collab_space_api.entity.NotificationEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationMapper {
    public NotificationEntity toEntity(NotificationRequestDTO request) {
        if (request == null) {
            return null;
        }
        NotificationEntity entity = new NotificationEntity();
        updateEntityFromRequest(entity, request);
        return entity;
    }

    public void updateEntityFromRequest(NotificationEntity entity, NotificationRequestDTO request) {
        if (entity == null || request == null) {
            return;
        }

        entity.setContent(request.getContent());
        entity.setUserId(request.getUserId());
    }

    public NotificationRequestDTO toResponseDTO(NotificationEntity entity) {
        if (entity == null) {
            return null;
        }
        NotificationRequestDTO response = new NotificationRequestDTO();
        response.setContent(entity.getContent());
        response.setUserId(entity.getUserId());
        return response;
    }

    public void updateEntity(NotificationEntity entity, NotificationRequestDTO request) {
        updateEntityFromRequest(entity, request);
    }
}
