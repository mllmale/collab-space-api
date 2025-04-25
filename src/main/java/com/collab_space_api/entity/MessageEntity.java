package com.collab_space_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Document(collection = "messages")
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {

    @Id
    private String id;
    private String senderId; // User ID of the sender
    private String content; // Message content
    private String teamId; // Team ID
    private String projectId; // Project ID
    private String sentAt; // Timestamp of when the message was sent
}