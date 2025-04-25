package com.collab_space_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "projects")
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    private String id;
    private String name;
    private String description;
    private String team_id; // Team ID
    private String owner_id; // User ID of the owner
    private String createdAt; // Timestamp of when the project was created
    private String updatedAt; // Timestamp of when the project was last updated
    private String status; // "active", "archived", etc.
    private String visibility; // "public", "private", etc.
    private String deadline; // Deadline for the project
    private String priority; // "low", "medium", "high"
}
