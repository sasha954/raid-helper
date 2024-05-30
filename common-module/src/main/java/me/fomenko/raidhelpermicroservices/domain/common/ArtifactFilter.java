package me.fomenko.raidhelpermicroservices.domain.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.fomenko.raidhelpermicroservices.enums.Rarity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtifactFilter {
    private Filter min;
    private Filter max;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor(staticName = "createFilter")
    public static class Filter {
        private Integer stars;
        private Rarity rarity;
    }
}
