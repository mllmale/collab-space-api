package com.collab_space_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    private String description;

    @NotBlank(message = "O ID do time é obrigatório")
    private String teamId;

    @NotBlank(message = "O ID do proprietário é obrigatório")
    private String ownerId;

    private String status;     // "ACTIVE", "ARCHIVED"
    private String visibility; // "PUBLIC", "PRIVATE"
    private String deadline;
    private String priority;   // "LOW", "MEDIUM", "HIGH"
}