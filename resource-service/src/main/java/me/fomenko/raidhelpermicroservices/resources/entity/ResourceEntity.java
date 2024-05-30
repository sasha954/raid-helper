package me.fomenko.raidhelpermicroservices.resources.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.fomenko.raidhelpermicroservices.enums.Location;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.EntityWriter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "resources")
public class ResourceEntity {

    @Id
    @Indexed
    @Field(name = "resource_id")
    private String resourceId;
    private String name;
    @Field(name = "resource_type", targetType = FieldType.STRING)
    private ResourceType resourceType;
    @Field(name = "created_at", targetType = FieldType.TIMESTAMP)
    private LocalDateTime createdAt;
    private List<ResourceRarity> rarities;
    private List<ResourceQuality> qualities;
    private List<String> locations;

}
