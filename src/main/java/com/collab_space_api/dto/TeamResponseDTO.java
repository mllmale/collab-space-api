package com.collab_space_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponseDTO {

    private String id;
    private String name;
    private String ownerId;
    private String createdAt;
}
