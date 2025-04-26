package com.collab_space_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NotificationRequestDTO {
    @NotBlank
    private String userId;

    @NotBlank
    private String content;
}
