package com.collab_space_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserRequestDTO {
    @NotBlank
    private String name; // User's name

    @Email
    String email;

    @NotBlank
    String passwordHash; // User's password

    LocalDateTime CreatedAt;
}
