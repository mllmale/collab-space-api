package com.collab_space_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password_hash; // Hashed password

    @Column(nullable = false)
    private String provider; // "google", "github", etc.

    @Column(nullable = false)
    private String providerId; // ID from the OAuth provider

    @Column(nullable = false)
    private String role; // "user", "admin", etc.

    @Column(nullable = false)
    private String createdAt; // Timestamp of when the user was created
}
