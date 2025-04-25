package com.collab_space_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserRequestDTO {
    @NotBlank
    private String name; // User's name

    @Email
    String email;

    @NotBlank
    String password; // User's password
}
