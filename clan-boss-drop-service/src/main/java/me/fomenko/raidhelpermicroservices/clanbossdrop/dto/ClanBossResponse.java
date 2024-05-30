package me.fomenko.raidhelpermicroservices.clanbossdrop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.fomenko.raidhelpermicroservices.clanbossdrop.entity.BossLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClanBossResponse {
    private String bossId;
    private String name;
    private String location;
    private List<ClanBossInfo> clanBossInfo = new ArrayList<>();
}
