package com.collab_space_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamUserResponseDTO {
    private String id;
    private String teamId;
    private String userId;
    private String role;
}
