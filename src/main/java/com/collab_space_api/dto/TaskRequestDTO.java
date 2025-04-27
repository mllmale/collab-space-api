package com.collab_space_api.dto;

import lombok.Data;

@Data
public class TaskRequestDTO {

    public enum Status {
        TODO,
        DOING,
        DONE
    }
    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }
    // Task ID
    private String name; // Task name
    private String description; // Task description
    private String status; // TODO, DOING, DONE
    private String priority; // LOW, MEDIUM, HIGH
    private String deadline; // Deadline for the task
    private String projectId;
    private String assignedTo; // User ID of the assignee
    private String createdAt; // Timestamp of when the task was created
}
