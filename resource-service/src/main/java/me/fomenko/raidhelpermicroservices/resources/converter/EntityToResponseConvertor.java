package me.fomenko.raidhelpermicroservices.resources.converter;

import me.fomenko.raidhelpermicroservices.resources.dto.ResourceResponse;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceEntity;
import org.springframework.core.convert.converter.Converter;

public class EntityToResponseConvertor implements Converter<ResourceEntity, ResourceResponse.ResourceResponseBuilder> {

    @Override
    public ResourceResponse.ResourceResponseBuilder convert(ResourceEntity source) {
        return ResourceResponse.builder()
                .withName(source.getName())
                .withResourceId(source.getResourceId())
                .withResourceType(source.getResourceType().name())
                .withCreatedAt(source.getCreatedAt());
    }
}
