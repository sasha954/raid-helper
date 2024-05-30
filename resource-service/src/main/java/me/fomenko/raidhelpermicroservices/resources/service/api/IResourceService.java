package me.fomenko.raidhelpermicroservices.resources.service.api;

import me.fomenko.raidhelpermicroservices.domain.common.ArtifactFilter;
import me.fomenko.raidhelpermicroservices.resources.dto.ResourceResponse;

import java.util.List;

/**
 * IResourceService.
 */
public interface IResourceService {

    /**
     * Returns resources by ids.
     *
     * @param resourcesId resources ids
     * @return list of resources
     */
    List<ResourceResponse> getResourcesByIds(List<String> resourcesId);

    /**
     * Returns all resources.
     *
     * @return list of resources
     */
    List<ResourceResponse> getAllResources();

    List<ResourceResponse> getResourcesByLocation(String location, List<ArtifactFilter> filters);
}
