package com.collab_space_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageResponseDTO {
    private String id;
    private String senderId;
    private String content;
    private String teamId;
    private String projectId;
    private String sentAt;
    private String receiverId;
}
