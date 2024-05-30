package me.fomenko.raidhelpermicroservices.resources.config;

import me.fomenko.raidhelpermicroservices.resources.converter.EntityToResponseConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
public class ResourceConfig {

    @Bean
    public ConversionService defaultConversionService(){
        final var conversionService = new DefaultConversionService();
        conversionService.addConverter(new EntityToResponseConvertor());
        return conversionService;
    }
}
