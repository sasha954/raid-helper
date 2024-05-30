package me.fomenko.raidhelpermicroservices.clanbossdrop.service.impl;

import lombok.RequiredArgsConstructor;
import me.fomenko.raidhelpermicroservices.clanbossdrop.client.ClanBossClient;
import me.fomenko.raidhelpermicroservices.clanbossdrop.dto.ClanBossResponse;
import me.fomenko.raidhelpermicroservices.clanbossdrop.repository.ClanBossRepository;
import me.fomenko.raidhelpermicroservices.clanbossdrop.service.api.IClanBossService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClanBossService implements IClanBossService {

    private final ClanBossClient clanBossClient;

    @Override
    public List<ClanBossResponse> getAllClanBosses() {
        return null;
    }

    @Override
    public List<ClanBossResponse> getClanBossesWithResources(String bossId) {
        return List.of(clanBossClient.getClanBossById(bossId).getBody().getContent());
    }
}
