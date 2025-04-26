package com.collab_space_api.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Document(collection = "team_users")
@NoArgsConstructor
@Data
public class TeamUserEntity {

    public enum Role {
        ADMIN,
        MEMBER,
        GUEST
    }

    @Id
    private String id;
    private String teamId; // Team ID
    private String userId; // User ID
    private Role role; // "admin", "member", etc.

}
