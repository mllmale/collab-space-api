package com.collab_space_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeamResponseDTO {

    private String id;
    private String name;
    private String ownerId;
    private String createdAt;
}
