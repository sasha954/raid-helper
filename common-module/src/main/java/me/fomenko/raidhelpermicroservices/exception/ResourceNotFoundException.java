package me.fomenko.raidhelpermicroservices.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RaidHelperRuntimeException {

    public ResourceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
