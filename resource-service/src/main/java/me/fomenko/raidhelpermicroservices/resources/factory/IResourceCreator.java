package me.fomenko.raidhelpermicroservices.resources.factory;

import me.fomenko.raidhelpermicroservices.resources.dto.ResourceResponse;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceEntity;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceType;

import java.util.List;

public interface IResourceCreator {

    List<ResourceResponse> createResourceResponse(ResourceEntity resourceEntity);
}
