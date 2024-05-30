package me.fomenko.raidhelpermicroservices.resources.entity;

import me.fomenko.raidhelpermicroservices.resources.entity.ResourceType;

import java.util.Arrays;
import java.util.List;

/**
 * Count of start on resource
 */
public enum ResourceQuality {
    /**
     * Uses for non artifacts / attributes and XP potion
     */
    NONE("None"),
    /**
     * Uses for artifacts / attributes
     */
    ONE_STAR("1"),
    TWO_STAR("2"),
    THREE_STAR("3"),
    FOUR_STAR("4"),
    FIVE_STAR("5"),
    SIX_STAR("6"),
    /**
     * Uses for dye potion
     */
    SMALL("Dye"),
    MEDIUM("Dye"),
    BIG("Dye");

    private final String value;

    ResourceQuality(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
