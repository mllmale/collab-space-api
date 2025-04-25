package com.collab_space_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NotificationUpdateDTO {
    @NotNull
    private Boolean read;
}
