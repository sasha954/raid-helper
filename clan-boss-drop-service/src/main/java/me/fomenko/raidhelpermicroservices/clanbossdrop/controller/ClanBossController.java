package me.fomenko.raidhelpermicroservices.clanbossdrop.controller;

import lombok.RequiredArgsConstructor;
import me.fomenko.raidhelpermicroservices.clanbossdrop.dto.ClanBossResponse;
import me.fomenko.raidhelpermicroservices.clanbossdrop.service.api.IClanBossService;
import me.fomenko.raidhelpermicroservices.domain.http.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/drops")
@RequiredArgsConstructor
public class ClanBossController {

    private final IClanBossService clanBossService;

    @GetMapping("/{bossId}/resources")
    public ResponseEntity<HttpResponse<List<ClanBossResponse>>> getClanBossByIdWithResources(
            @PathVariable String bossId) {
        final var response = clanBossService.getClanBossesWithResources(bossId);
        return HttpResponse.ok(response);
    }
}
