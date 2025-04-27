package com.collab_space_api.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MessageEntity {

    @Id
    private String id;
    private String senderId; // User ID of the sender
    private String receiverId; // User ID of the receiver
    private String content; // Message content
    private String teamId; // Team ID
    private String projectId; // Project ID
    private String sentAt; // Timestamp of when the message was sent
}