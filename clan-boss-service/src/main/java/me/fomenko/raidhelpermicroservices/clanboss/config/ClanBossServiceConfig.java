package me.fomenko.raidhelpermicroservices.clanboss.config;

import me.fomenko.raidhelpermicroservices.clanboss.converter.ClanBossEntityToResponseConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ClanBossServiceConfig {


    @Bean
    public ConversionService defaultConversionService() {
        final var conversionService = new DefaultConversionService();
        conversionService.addConverter(new ClanBossEntityToResponseConverter());
        return conversionService;
    }
}
