package com.collab_space_api.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Document(collection = "team_users")
@NoArgsConstructor
public class TeamUser {

    private enum Role {
        ADMIN,
        MEMBER,
        GUEST
    }

    @Id
    private String id;
    private String team_id; // Team ID
    private String user_id; // User ID
    private Role role; // "admin", "member", etc.

}
