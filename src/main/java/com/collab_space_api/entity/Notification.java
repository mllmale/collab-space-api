package com.collab_space_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "notifications")
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    private String id;
    private String userId; // User ID of the recipient
    private String content; // Notification content
    private boolean read; // Read status
    private String createdAt; // Timestamp of when the notification was created
}
