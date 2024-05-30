package me.fomenko.raidhelpermicroservices.resources.exception;

/**
 * ResourceRuntimeException.
 */
public class ResourceRuntimeException extends RuntimeException {
    public ResourceRuntimeException() {
        super();
    }

    public ResourceRuntimeException(String message) {
        super(message);
    }
}
