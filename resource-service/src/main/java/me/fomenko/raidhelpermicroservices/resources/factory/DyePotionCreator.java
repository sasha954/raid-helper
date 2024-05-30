package me.fomenko.raidhelpermicroservices.resources.factory;

import lombok.RequiredArgsConstructor;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceQuality;
import me.fomenko.raidhelpermicroservices.resources.dto.ResourceResponse;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceEntity;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceRarity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class DyePotionCreator implements IResourceCreator {

    private final ConversionService defaultConversionService;

    @Override
    public List<ResourceResponse> createResourceResponse(ResourceEntity resourceEntity) {
        return Arrays.stream(Type.values())
                .flatMap(type -> resourceEntity.getQualities().stream()
                        .map(quality -> {
                            final var resource = Objects.requireNonNull(defaultConversionService
                                    .convert(resourceEntity, ResourceResponse.ResourceResponseBuilder.class)).build();
                            final var name = buildName(resource.getName(), quality, type);
                            resource.setName(name);
                            resource.setRarity(ResourceRarity.NONE.name());
                            resource.setQuality(Map.of(quality.name(), toCapitalCase(quality.getValue())));
                            return resource;
                        }))

                .toList();
    }

    private String buildName(String name, ResourceQuality resourceType, Type type) {
        final var stringBuilder = new StringBuilder()
                .append(toCapitalCase(resourceType.name()))
                .append(" ")
                .append(toCapitalCase(type.name()))
                .append(" ")
                .append(name);
        return stringBuilder.toString();
    }

    private static String toCapitalCase(String str) {
        return StringUtils.substring(str, 0, 1) + StringUtils.lowerCase(StringUtils.substring(str, 1));
    }

    private enum Type {
        MAGIC, FORCE, SPIRIT, VOID
    }
}
