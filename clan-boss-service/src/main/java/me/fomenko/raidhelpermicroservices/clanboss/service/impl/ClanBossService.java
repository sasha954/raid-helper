package me.fomenko.raidhelpermicroservices.clanboss.service.impl;

import lombok.RequiredArgsConstructor;
import me.fomenko.raidhelpermicroservices.clanboss.dto.ClanBossResponse;
import me.fomenko.raidhelpermicroservices.clanboss.entity.ClanBossEntity;
import me.fomenko.raidhelpermicroservices.clanboss.repository.ClanBossRepository;
import me.fomenko.raidhelpermicroservices.clanboss.service.api.IClanBossService;
import me.fomenko.raidhelpermicroservices.exception.InvalidParameterException;
import me.fomenko.raidhelpermicroservices.exception.ResourceNotFoundException;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClanBossService implements IClanBossService {
    private final ClanBossRepository clanBossRepository;
    private final ConversionService defaultConversionService;
    @Override
    public ClanBossResponse getClanBossWithInfoById(String bossId) {
        if (!StringUtils.hasText(bossId)) {
            throw new InvalidParameterException("Id parameter is empty. Try again.", HttpStatus.BAD_REQUEST);
        }

        final var clanBoss = clanBossRepository.findById(StringUtils.trimAllWhitespace(bossId))
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Clan boss with specified id [%s] does not exists.", bossId)));

        return defaultConversionService.convert(clanBoss, ClanBossResponse.class);
    }
}
