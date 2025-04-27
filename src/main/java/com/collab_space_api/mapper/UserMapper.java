package com.collab_space_api.mapper;

import com.collab_space_api.dto.UserRequestDTO;
import com.collab_space_api.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public UserEntity toEntity(UserRequestDTO request) {
        if (request == null) {
            return null;
        }
        UserEntity entity = new UserEntity();
        updateEntityFromRequest(entity, request);
        return entity;
    }

    public void updateEntityFromRequest(UserEntity entity, UserRequestDTO request) {
        if (entity == null || request == null) {
            return;
        }

        entity.setName(request.getName());
        entity.setEmail(request.getEmail());
        entity.setPasswordHash(request.getPasswordHash());
        entity.setCreatedAt(request.getCreatedAt());
    }

    public UserRequestDTO toResponseDTO(UserEntity entity) {
        if (entity == null) {
            return null;
        }
        UserRequestDTO response = new UserRequestDTO();
        response.setName(entity.getName());
        response.setEmail(entity.getEmail());
        response.setPasswordHash(entity.getPasswordHash());
        response.setCreatedAt(entity.getCreatedAt());
        return response;
    }

    public void updateEntity(UserEntity entity, UserRequestDTO request) {
        updateEntityFromRequest(entity, request);
    }
}
