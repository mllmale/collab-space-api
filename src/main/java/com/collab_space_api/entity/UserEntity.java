package com.collab_space_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    public enum Provider {
        GOOGLE, GITHUB, LOCAL
    }

    public enum Role {
        USER, ADMIN, MODERATOR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    @Column(unique = true)
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private Provider provider;

    @NotBlank
    private String providerId;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private Role role;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}

