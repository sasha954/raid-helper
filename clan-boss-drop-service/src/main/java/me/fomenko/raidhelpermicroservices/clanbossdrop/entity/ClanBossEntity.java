package me.fomenko.raidhelpermicroservices.clanbossdrop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clan_bosses")
public class ClanBossEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Enumerated(EnumType.STRING)
    private BossLevel level;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clanBoss")
    private List<BossDropEntity> bossDrop = new ArrayList<>();
}
