package com.collab_space_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequestDTO {

    @NotBlank(message = "O ID do remetente é obrigatório.")
    private String senderId;

    @NotBlank(message = "O conteúdo da mensagem é obrigatório.")
    private String content;

    @NotBlank(message = "O ID do time é obrigatório.")
    private String teamId;

    @NotBlank(message = "O ID do projeto é obrigatório.")
    private String projectId;
}
