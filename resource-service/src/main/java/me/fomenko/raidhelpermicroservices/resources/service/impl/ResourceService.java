package me.fomenko.raidhelpermicroservices.resources.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.fomenko.raidhelpermicroservices.domain.common.ArtifactFilter;
import me.fomenko.raidhelpermicroservices.resources.dto.ResourceResponse;
import me.fomenko.raidhelpermicroservices.resources.entity.ResourceEntity;
import me.fomenko.raidhelpermicroservices.resources.factory.ResourceFactory;
import me.fomenko.raidhelpermicroservices.resources.repository.ResourceRepository;
import me.fomenko.raidhelpermicroservices.resources.service.api.IResourceService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Implentation of {@link IResourceService}.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ResourceService implements IResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceFactory resourceFactory;

    @Override
    public List<ResourceResponse> getResourcesByIds(List<String> resourcesId) {
        if (resourcesId.isEmpty()) {
            log.info("List with resources ids is empty.");
            return Collections.emptyList();
        }

        log.info("Request to get resources with ids, {}", resourcesId);
        return resourceRepository.findAllById(resourcesId)
                .stream()
                .map((ResourceEntity resourceEntity) -> {
                    final var resourceCreator = resourceFactory.getCreator(resourceEntity.getResourceType());
                    return resourceCreator.createResourceResponse(resourceEntity);
                })
                .flatMap(Collection::stream)
                .toList();
    }

    @Override
    public List<ResourceResponse> getAllResources() {
        log.info("Request to get all resources");
        return resourceRepository.findAll()
                .stream()
                .map((ResourceEntity resourceEntity) -> {
                    final var resourceCreator = resourceFactory.getCreator(resourceEntity.getResourceType());
                    return resourceCreator.createResourceResponse(resourceEntity);
                })
                .flatMap(Collection::stream)
                .toList();
    }

    @Override
    public List<ResourceResponse> getResourcesByLocation(String location, List<ArtifactFilter> filters) {
        log.info("Request to get resources by location [{}].", location);
        return List.of();
    }
}
