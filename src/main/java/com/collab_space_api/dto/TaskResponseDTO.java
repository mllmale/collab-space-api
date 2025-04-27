package com.collab_space_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {
    private String id;
    private String name;
    private String description;
    private String status;
    private String priority;
    private String deadline;
    private String projectId;
    private String assignedTo;
    private String createdAt;

    // Add any other fields or methods as needed
}
