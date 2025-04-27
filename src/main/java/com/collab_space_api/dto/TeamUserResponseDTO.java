package com.collab_space_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamUserResponseDTO {
    private String id;
    private String teamId;
    private String userId;
    private String role;
}
