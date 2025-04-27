package com.collab_space_api.mapper;

import com.collab_space_api.dto.MessageResponseDTO;
import com.collab_space_api.entity.MessageEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageMapper {
    private static final String COLLECTION_NAME = "messages";
    
    public MessageEntity ToEntity(MessageResponseDTO response) {
        if (!isValidInput(response)) {
            return null;
        }
        return MessageEntity.builder()
                .id(response.getId())
                .senderId(response.getSenderId())
                .content(response.getContent())
                .sentAt(response.getSentAt())
                .projectId(response.getProjectId())
                .teamId(response.getTeamId())
                .receiverId(response.getReceiverId())
                .build();
    }

    public MessageResponseDTO ToResponseDTO(MessageEntity entity) {
        if (!isValidInput(entity)) {
            return null;
        }
        return MessageResponseDTO.builder()
                .id(entity.getId())
                .senderId(entity.getSenderId())
                .content(entity.getContent())
                .sentAt(entity.getSentAt())
                .projectId(entity.getProjectId())
                .teamId(entity.getTeamId())
                .receiverId(entity.getReceiverId())
                .build();
    }

    public void updateEntityFromResponse(MessageEntity entity, MessageResponseDTO response) {
        if (!isValidInput(entity, response)) {
            return;
        }
        entity.setId(response.getId());
        entity.setSenderId(response.getSenderId());
        entity.setContent(response.getContent());
        entity.setSentAt(response.getSentAt());
        entity.setProjectId(response.getProjectId());
        entity.setTeamId(response.getTeamId());
        entity.setReceiverId(response.getReceiverId());
    }

    private boolean isValidInput(Object... inputs) {
        for (Object input : inputs) {
            if (input == null) {
                return false;
            }
        }
        return true;
    }
}