package com.collab_space_api.dto;

import lombok.Data;

@Data
public class ProjectUpdateDTO {
    private String name;
    private String description;
    private String status;     // "active", "archived"
    private String visibility; // "public", "private"
    private String deadline;
    private String priority;
}
