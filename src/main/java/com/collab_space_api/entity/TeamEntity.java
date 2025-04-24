package com.collab_space_api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
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
}
