package me.fomenko.raidhelpermicroservices.clanbossdrop.client;

import me.fomenko.raidhelpermicroservices.clanbossdrop.dto.ResourceResponse;
import me.fomenko.raidhelpermicroservices.domain.http.HttpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("RESOURCE-SERVICE")
public interface ResourceClient {

    @GetMapping("/api/resources")
    ResponseEntity<HttpResponse<List<ResourceResponse>>> getAllResources(
            @RequestParam(value = "resourceId", required = false, defaultValue = "") List<String> resourcesIds);
}
