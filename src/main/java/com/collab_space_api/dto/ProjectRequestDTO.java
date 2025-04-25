package com.collab_space_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProjectRequestDTO {

    @NotBlank(message = "O nome do projeto é obrigatório.")
    private String name;

    private String description;

    @NotBlank(message = "O ID do time é obrigatório.")
    private String teamId;

    private String status;
    private String visibility;
    private String deadline;   // opcional
    private String priority;   // opcional
}
