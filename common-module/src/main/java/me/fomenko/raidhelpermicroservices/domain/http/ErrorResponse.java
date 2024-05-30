package me.fomenko.raidhelpermicroservices.domain.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import me.fomenko.raidhelpermicroservices.domain.common.Builder;
import me.fomenko.raidhelpermicroservices.domain.common.DomainBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final HttpStatus status;
    private final String message;
    private final LocalDateTime currentDateTime;
    private final Map<String, String> additionalInfo;

    private ErrorResponse(HttpStatus status, String message, LocalDateTime currentDateTime, Map<String, String> additionalInfo) {
        this.status = status;
        this.message = message;
        this.currentDateTime = currentDateTime;
        this.additionalInfo = additionalInfo;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    public Map<String, String> getAdditionalInfo() {
        return additionalInfo;
    }

    public static ErrorResponse.ErrorResponseBuilder builder() {
        return new ErrorResponse.ErrorResponseBuilder();
    }

    public static class ErrorResponseBuilder implements Builder<ErrorResponse> {
        private HttpStatus status;
        private String message;
        private LocalDateTime currentDateTime;
        private Map<String, String> additionalInfo;

        private ErrorResponseBuilder() {
            //No op.
        }

        public ErrorResponse.ErrorResponseBuilder withStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponseBuilder withCurrentDateTime(LocalDateTime currentDateTime) {
            this.currentDateTime = currentDateTime;
            return this;
        }

        public ErrorResponseBuilder withAdditionalInfo(Map<String, String> additionalInfo) {
            this.additionalInfo = additionalInfo;
            return this;
        }

        @Override
        public ErrorResponse build() {
            return new ErrorResponse(this.status, this.message, this.currentDateTime, this.additionalInfo);
        }
    }
}
