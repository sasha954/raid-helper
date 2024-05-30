package me.fomenko.raidhelpermicroservices.clanbossdrop.entity;

public enum BossLevel {
    EASE("Ease"),
    NORMAL("Normal"),
    HARD("Hard"),
    BRUTAL("Brutal"),
    NIGHTMARE("Nightmare"),
    ULTRA_NIGHTMARE("Ultra Nightmare");

    private final String value;

    BossLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
