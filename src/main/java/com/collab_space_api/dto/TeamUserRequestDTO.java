package com.collab_space_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TeamUserRequestDTO {

    @NotBlank(message = "O ID do time é obrigatório.")
    private String teamId;

    @NotBlank(message = "O ID do usuário é obrigatório.")
    private String userId;

    @NotBlank(message = "O papel do usuário é obrigatório.")
    private String role; // "admin", "member", etc.
}
