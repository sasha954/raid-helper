package me.fomenko.raidhelpermicroservices.resources.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceType;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class ResourceResponse {
    private String resourceId;
    private String name;
    private String resourceType;
    private String rarity;
    private Map<String, String> quality;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdAt;
}
