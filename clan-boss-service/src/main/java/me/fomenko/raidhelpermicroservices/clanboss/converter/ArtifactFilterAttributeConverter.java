package me.fomenko.raidhelpermicroservices.clanboss.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;
import me.fomenko.raidhelpermicroservices.domain.common.ArtifactFilter;
import me.fomenko.raidhelpermicroservices.exception.RaidHelperRuntimeException;
import org.springframework.http.HttpStatus;

@Converter
@Slf4j
public class ArtifactFilterAttributeConverter implements AttributeConverter<ArtifactFilter, String> {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final String CONVERT_TO_JSON_ERROR_MESSAGE = "Could not convert object to json string.";
    public static final String CONVERT_TO_OBJECT_ERROR_MESSAGE = "Could not convert json string to object.";

    @Override
    public String convertToDatabaseColumn(ArtifactFilter artifactFilter) {
        try {
            return OBJECT_MAPPER.writeValueAsString(artifactFilter);
        } catch (JsonProcessingException e) {
            log.error(CONVERT_TO_JSON_ERROR_MESSAGE, e);
            throw new RaidHelperRuntimeException(CONVERT_TO_JSON_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ArtifactFilter convertToEntityAttribute(String json) {
        try {
            return OBJECT_MAPPER.readValue(json, ArtifactFilter.class);
        } catch (JsonProcessingException e) {
            log.error(CONVERT_TO_OBJECT_ERROR_MESSAGE, e);
            throw new RaidHelperRuntimeException(CONVERT_TO_OBJECT_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
