package me.fomenko.raidhelpermicroservices.clanbossdrop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="boss_drops")
public class BossDropEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String itemId;
    private UUID userId;
    private int quantity;
    @ManyToOne(optional = false)
    @JoinColumn(name="boss_id", nullable=false, updatable=false)
    private ClanBossEntity clanBoss;
}
