package me.fomenko.raidhelpermicroservices.resources.factory;

import lombok.RequiredArgsConstructor;
import me.fomenko.raidhelpermicroservices.resources.dto.ResourceResponse;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceEntity;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CommonCreator implements IResourceCreator {

    private final ConversionService defaultConversionService;

    @Override
    public List<ResourceResponse> createResourceResponse(ResourceEntity resourceEntity) {
        return resourceEntity.getQualities().stream().flatMap(resourceQuality -> resourceEntity.getRarities().stream()
                .map(rarity -> Objects.requireNonNull(defaultConversionService
                                .convert(resourceEntity, ResourceResponse.ResourceResponseBuilder.class))
                        .withRarity(rarity.name())
                        .withQuality(Map.of(resourceQuality.name(), resourceQuality.getValue()))
                        .build())).toList();
    }
}
