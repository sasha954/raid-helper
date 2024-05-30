package me.fomenko.raidhelpermicroservices.clanboss.converter;

import me.fomenko.raidhelpermicroservices.clanboss.dto.ClanBossInfo;
import me.fomenko.raidhelpermicroservices.clanboss.dto.ClanBossResponse;
import me.fomenko.raidhelpermicroservices.clanboss.entity.ClanBossEntity;
import me.fomenko.raidhelpermicroservices.clanboss.entity.ClanBossInfoEntity;
import org.springframework.core.convert.converter.Converter;

public class ClanBossEntityToResponseConverter implements Converter<ClanBossEntity, ClanBossResponse> {

    @Override
    public ClanBossResponse convert(ClanBossEntity source) {
        final var clanBossInfos = source.getBossInfo()
                .stream()
                .map((ClanBossInfoEntity entity) -> ClanBossInfo.builder()
                        .level(entity.getLevel())
                        .maxHp(entity.getMaxHp())
                        .attackPower(entity.getAttackPower())
                        .defence(entity.getDefence())
                        .speed(entity.getSpeed())
                        .resistance(entity.getResistance())
                        .accuracy(entity.getAccuracy())
                        .artifactFilter(entity.getArtifactFilter())
                        .build())
                .toList();

        return ClanBossResponse.builder()
                .bossId(source.getBossId())
                .location(source.getLocation().name())
                .name(source.getName())
                .clanBossInfo(clanBossInfos)
                .build();
    }
}
