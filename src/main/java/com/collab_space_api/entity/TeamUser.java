package com.collab_space_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@AllArgsConstructor
@Document(collection = "team_users")
@NoArgsConstructor
public class TeamUser {
    @Id
    private String id;
    private String team_id; // Team ID
    private String user_id; // User ID
    private String role; // "admin", "member", etc.

}
