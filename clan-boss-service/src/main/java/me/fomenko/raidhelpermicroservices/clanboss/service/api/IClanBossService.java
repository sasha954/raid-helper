package me.fomenko.raidhelpermicroservices.clanboss.service.api;

import me.fomenko.raidhelpermicroservices.clanboss.dto.ClanBossResponse;

public interface IClanBossService {
    ClanBossResponse getClanBossWithInfoById(String bossId);
}
