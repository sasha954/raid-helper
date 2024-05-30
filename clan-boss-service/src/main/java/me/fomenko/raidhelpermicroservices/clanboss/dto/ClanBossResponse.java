package me.fomenko.raidhelpermicroservices.clanboss.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
