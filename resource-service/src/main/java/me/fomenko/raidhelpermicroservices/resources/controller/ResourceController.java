package me.fomenko.raidhelpermicroservices.resources.controller;

import lombok.RequiredArgsConstructor;
import me.fomenko.raidhelpermicroservices.domain.common.ArtifactFilter;
import me.fomenko.raidhelpermicroservices.domain.http.HttpResponse;
import me.fomenko.raidhelpermicroservices.resources.dto.ResourceResponse;
import me.fomenko.raidhelpermicroservices.resources.service.api.IResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResourceController {

    private final IResourceService resourceService;

    @GetMapping("/resources")
    public ResponseEntity<HttpResponse<List<ResourceResponse>>> getAllResources(
            @RequestParam(value = "resourceId", required = false, defaultValue = "") List<String> resourcesIds) {
        if (resourcesIds.isEmpty()) {
            return HttpResponse.ok(resourceService.getAllResources());
        }
        return HttpResponse.ok(resourceService.getResourcesByIds(resourcesIds));
    }

    @PostMapping("/resources/{location}")
    public ResponseEntity<HttpResponse<List<ResourceResponse>>> getResourcesByLocation(@PathVariable String location,
            @RequestBody List<ArtifactFilter> filters) {
        return HttpResponse.ok(resourceService.getResourcesByLocation(location, filters));
    }
}
