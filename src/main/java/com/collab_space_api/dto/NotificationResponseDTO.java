package com.collab_space_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationResponseDTO {
    private String id;
    private String userId;
    private String content;
    private boolean read;
    private String createdAt;
}
