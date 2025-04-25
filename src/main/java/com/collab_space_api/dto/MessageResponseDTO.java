package com.collab_space_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageResponseDTO {
    private String id;
    private String senderId;
    private String content;
    private String teamId;
    private String projectId;
    private String sentAt;
}
