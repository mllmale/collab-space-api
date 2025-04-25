package com.collab_space_api.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    private String id;
    private String name; // Task name
    private String description; // Task description
    private String status; // TODO, DOING, DONE
    private String priority; // LOW, MEDIUM, HIGH
    private String deadline; // Deadline for the task
    private String projectId;
    private String assignedTo; // User ID of the assignee
    private String createdAt; // Timestamp of when the task was created
}
