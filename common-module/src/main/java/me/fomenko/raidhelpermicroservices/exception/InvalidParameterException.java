package me.fomenko.raidhelpermicroservices.exception;

import org.springframework.http.HttpStatus;

/**
 * InvalidParameterException.
 */
public class InvalidParameterException extends RaidHelperRuntimeException {

    public InvalidParameterException(String message, HttpStatus status) {
        super(message, status);
    }
}
