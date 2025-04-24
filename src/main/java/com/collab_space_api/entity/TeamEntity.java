package com.collab_space_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Entity
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
    private String owner_id; // User ID of the owner
    private String crateAt; // Timestamp of when the team was created
}
