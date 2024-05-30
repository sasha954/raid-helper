package me.fomenko.raidhelpermicroservices.clanboss.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.fomenko.raidhelpermicroservices.enums.Location;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clan_boss")
public class ClanBossEntity {

    @Id
    private String bossId;
    private String name;
    @Enumerated(EnumType.STRING)
    private Location location;
    @OneToMany(mappedBy = "clanBoss", cascade = CascadeType.ALL)
    private List<ClanBossInfoEntity> bossInfo = new ArrayList<>();
}
