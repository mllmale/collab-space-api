package com.collab_space_api.dto;

import lombok.Data;

@Data
public class OAuthUserDTO {
    private String name;
    private String email;
    private String provider; // "google"
    private String providerId; // ID fornecido pelo Google
}
