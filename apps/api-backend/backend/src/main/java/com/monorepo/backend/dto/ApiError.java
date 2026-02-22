package com.monorepo.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * Standardized API error envelope.
 * Frontend can rely on this shape for all 4xx/5xx responses.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiError(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path,
        String traceId,
        Map<String, List<String>> fieldErrors   // validation errors per field
) {
    public static ApiError of(int status, String error, String message, String path, String traceId) {
        return new ApiError(Instant.now(), status, error, message, path, traceId, null);
    }

    public static ApiError withValidation(
            int status, String message, String path, String traceId,
            Map<String, List<String>> fieldErrors) {
        return new ApiError(Instant.now(), status, "Validation Failed", message, path, traceId, fieldErrors);
    }
}
