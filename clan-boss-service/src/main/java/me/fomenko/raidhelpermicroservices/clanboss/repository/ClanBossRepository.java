package me.fomenko.raidhelpermicroservices.clanboss.repository;

import me.fomenko.raidhelpermicroservices.clanboss.entity.ClanBossEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClanBossRepository extends JpaRepository<ClanBossEntity, String> {
}
