package me.fomenko.raidhelpermicroservices.clanbossdrop.client;

import me.fomenko.raidhelpermicroservices.clanbossdrop.dto.ClanBossResponse;
import me.fomenko.raidhelpermicroservices.domain.http.HttpResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("CLAN-BOSS-SERVICE")
public interface ClanBossClient {

    @GetMapping("/api/clan-bosses/{bossId}")
    ResponseEntity<HttpResponse<ClanBossResponse>> getClanBossById(@PathVariable String bossId);
}
