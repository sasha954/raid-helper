package me.fomenko.raidhelpermicroservices.clanbossdrop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResourceResponse {
    private String resourceId;
    private String name;
    private String resourceType;
    private String quality;
    private String rarity;
    private String createdAt;
}
