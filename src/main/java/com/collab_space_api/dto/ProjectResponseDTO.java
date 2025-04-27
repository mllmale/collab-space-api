package com.collab_space_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDTO {
    private String id;
    private String name;
    private String description;
    private String teamId;
    private String ownerId;
    private String createdAt;
    private String updatedAt;
    private String status;
    private String visibility;
    private String deadline;
    private String priority;
}
