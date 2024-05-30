package me.fomenko.raidhelpermicroservices.exception;

import org.springframework.http.HttpStatus;

/**
 * RaidHelperRuntimeException.
 */
public class RaidHelperRuntimeException extends RuntimeException {
    private final HttpStatus httpStatus;

    public RaidHelperRuntimeException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
