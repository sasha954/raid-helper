package me.fomenko.raidhelpermicroservices.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.fomenko.raidhelpermicroservices.enums.Location;
import me.fomenko.raidhelpermicroservices.resources.dto.ResourceResponse;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceEntity;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceQuality;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceRarity;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceType;
import me.fomenko.raidhelpermicroservices.resources.repository.ResourceRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class ResourceServiceApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(ResourceServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(ResourceRepository resourceRepository) {
        return arg -> {
            resourceRepository.deleteAll();

            final var res1 = ResourceEntity.builder()
                    .resourceId("RH_ARTIFACT")
                    .resourceType(ResourceType.ARTIFACT)
                    .name("Artifact")
                    .rarities(Arrays.stream(ResourceRarity.values()).filter(resourceRarity ->
                            !resourceRarity.equals(ResourceRarity.NONE)).toList())
                    .qualities(Arrays.stream(ResourceQuality.values()).filter(resourceQuality ->
                            StringUtils.isNumeric(resourceQuality.getValue())).toList())
                    .createdAt(LocalDateTime.now())
                    .build();
            final var res2 = ResourceEntity.builder()
                    .resourceId("RH_SILVER")
                    .resourceType(ResourceType.MONEY)
                    .name("Silver")
                    .rarities(List.of(ResourceRarity.NONE))
                    .qualities(List.of(ResourceQuality.NONE))
                    .createdAt(LocalDateTime.now())
                    .build();
            final var res3 = ResourceEntity.builder()
                    .resourceId("RH_DYE_POTION")
                    .resourceType(ResourceType.DYE_POTION)
                    .name("Potion")
                    .rarities(List.of(ResourceRarity.NONE))
                    .qualities(Arrays.stream(ResourceQuality.values()).filter(resourceQuality ->
                            StringUtils.isAlpha(resourceQuality.getValue()) &&
                                    !resourceQuality.equals(ResourceQuality.NONE)).toList())
                    .createdAt(LocalDateTime.now())
                    .build();

            resourceRepository.saveAll(List.of(res1, res2, res3));
        };
    }
}
