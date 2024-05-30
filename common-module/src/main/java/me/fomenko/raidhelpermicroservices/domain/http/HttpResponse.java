package me.fomenko.raidhelpermicroservices.domain.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import me.fomenko.raidhelpermicroservices.domain.common.Builder;
import org.springframework.http.ResponseEntity;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HttpResponse<C> {

    private final C content;
    private final ErrorResponse errorResponse;

    private HttpResponse(C content, ErrorResponse errorResponse) {
        this.content = content;
        this.errorResponse = errorResponse;
    }

    public C getContent() {
        return content;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public static <C> ResponseEntity<HttpResponse<C>> ok(C content) {
        final var response = HttpResponse.<C>builder()
                .withContent(content)
                .build();

        return ResponseEntity.ok(response);
    }

    public static <C> ResponseEntity<HttpResponse<C>> error(ErrorResponse errorResponse) {
        final var response = HttpResponse.<C>builder()
                .withErrorResponse(errorResponse)
                .build();

        return ResponseEntity
                .status(errorResponse.getStatus())
                .body(response);
    }


    public static <C> HttpResponse.HttpResponseBuilder<C>  builder() {
        return new HttpResponse.HttpResponseBuilder<>();
    }

    public static class HttpResponseBuilder<C> implements Builder<HttpResponse<C>> {
        private C content;
        private ErrorResponse errorResponse;

        private HttpResponseBuilder() {
            //no op.
        }

        public HttpResponseBuilder<C> withContent(C content) {
            this.content = content;
            return this;
        }

        public HttpResponseBuilder<C> withErrorResponse(ErrorResponse errorResponse) {
            this.errorResponse = errorResponse;
            return this;
        }

        @Override
        public HttpResponse<C> build() {
            return new HttpResponse<>(this.content, this.errorResponse);
        }
    }
}
