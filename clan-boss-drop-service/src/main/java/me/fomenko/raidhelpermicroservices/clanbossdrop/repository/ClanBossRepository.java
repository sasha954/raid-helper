package me.fomenko.raidhelpermicroservices.clanbossdrop.repository;

import me.fomenko.raidhelpermicroservices.clanbossdrop.entity.ClanBossEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClanBossRepository extends JpaRepository<ClanBossEntity, String> {
}
