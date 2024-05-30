package me.fomenko.raidhelpermicroservices.clanboss.controller;

import lombok.RequiredArgsConstructor;
import me.fomenko.raidhelpermicroservices.clanboss.dto.ClanBossResponse;
import me.fomenko.raidhelpermicroservices.clanboss.service.api.IClanBossService;
import me.fomenko.raidhelpermicroservices.domain.http.ErrorResponse;
import me.fomenko.raidhelpermicroservices.domain.http.HttpResponse;
import me.fomenko.raidhelpermicroservices.exception.RaidHelperRuntimeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/clan-bosses")
@RequiredArgsConstructor
public class ClanBossController {

    private final IClanBossService clanBossService;

    @GetMapping("/{bossId}")
    public ResponseEntity<HttpResponse<ClanBossResponse>> getClanBossById(@PathVariable String bossId) {
        return HttpResponse.ok(clanBossService.getClanBossWithInfoById(bossId));
    }


    @ExceptionHandler({RaidHelperRuntimeException.class})
    public <T> ResponseEntity<HttpResponse<T>> handleException(RaidHelperRuntimeException ex) {
        final var errorResponse = ErrorResponse
                .builder()
                .withMessage(ex.getMessage())
                .withStatus(ex.getHttpStatus())
                .withCurrentDateTime(LocalDateTime.now())
                .build();

        return HttpResponse.error(errorResponse);
    }
}
