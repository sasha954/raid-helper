package me.fomenko.raidhelpermicroservices.clanbossdrop.service.api;

import me.fomenko.raidhelpermicroservices.clanbossdrop.dto.ClanBossResponse;

import java.util.List;

public interface IClanBossService {

    List<ClanBossResponse> getAllClanBosses();

    List<ClanBossResponse> getClanBossesWithResources(String bossId);

}
