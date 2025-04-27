package com.collab_space_api.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projects")
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectEntity {

    public enum Status {
        ACTIVE,
        ARCHIVED
    }
    public enum Visibility {
        PUBLIC,
        PRIVATE
    }
    public enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }
    @Id
    private String id;
    private String name;
    private String description;
    private String teamId; // Team ID
    private String ownerId; // User ID of the owner
    private String createdAt; // Timestamp of when the project was created
    private String updatedAt; // Timestamp of when the project was last updated
    private Status status; // "active", "archived", etc.
    private Visibility visibility; // "public", "private", etc.
    private String deadline; // Deadline for the project
    private Priority priority; // "low", "medium", "high"
}
