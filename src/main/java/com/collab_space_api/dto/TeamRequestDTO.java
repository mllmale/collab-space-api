package com.collab_space_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TeamRequestDTO {

    @NotBlank(message = "O nome do time é obrigatório.")
    private String name;

    @NotBlank(message = "O ID do proprietário é obrigatório.")
    private String ownerId;

    private LocalDateTime createdAt;
}
