package com.collab_space_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@AllArgsConstructor
@Document(collection = "usuarios")
@Data
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TeamEntity {
    @Id
    private String id;
    private String name;
    private String ownerId; // User ID of the owner
    private String crateAt; // Timestamp of when the team was created
}
