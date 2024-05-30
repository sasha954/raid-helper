package me.fomenko.raidhelpermicroservices.clanboss.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.fomenko.raidhelpermicroservices.clanboss.converter.ArtifactFilterAttributeConverter;
import me.fomenko.raidhelpermicroservices.domain.common.ArtifactFilter;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clan_boss_info")
public class ClanBossInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID infoId;
    private String level;
    private int maxHp;
    private int attackPower;
    private int defence;
    private int speed;
    private int accuracy;
    private int resistance;
    @Convert(converter = ArtifactFilterAttributeConverter.class)
    private ArtifactFilter artifactFilter;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="boss_id", nullable=false)
    private ClanBossEntity clanBoss;
}
