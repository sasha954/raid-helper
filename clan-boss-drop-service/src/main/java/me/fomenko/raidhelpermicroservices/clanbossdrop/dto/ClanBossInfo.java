package me.fomenko.raidhelpermicroservices.clanbossdrop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.fomenko.raidhelpermicroservices.domain.common.ArtifactFilter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClanBossInfo {
    private String level;
    private int maxHp;
    private int attackPower;
    private int defence;
    private int speed;
    private int accuracy;
    private int resistance;
    private ArtifactFilter artifactFilter;
}
