package com.collab_space_api.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projects")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    private enum Status {
        ACTIVE,
        ARCHIVED
    }
    private enum Visibility {
        PUBLIC,
        PRIVATE
    }
    private enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }
    @Id
    private String id;
    private String name;
    private String description;
    private String team_id; // Team ID
    private String owner_id; // User ID of the owner
    private String createdAt; // Timestamp of when the project was created
    private String updatedAt; // Timestamp of when the project was last updated
    private Status status; // "active", "archived", etc.
    private Visibility visibility; // "public", "private", etc.
    private String deadline; // Deadline for the project
    private Priority priority; // "low", "medium", "high"
}
