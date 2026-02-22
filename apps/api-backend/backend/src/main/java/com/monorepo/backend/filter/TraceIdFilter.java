package com.monorepo.backend.filter;

import io.opentelemetry.api.trace.Span;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Propagates the OpenTelemetry Trace ID into:
 *   1. The HTTP response header X-Trace-Id  (visible to clients / API consumers)
 *   2. MDC key "traceId"                    (picked up by logstash-logback-encoder → Loki)
 *
 * This satisfies the AI_Context.md requirement:
 *   "Every backend response must include the X-Trace-Id header."
 */
@Component
@Order(1)
public class TraceIdFilter extends OncePerRequestFilter {

    private static final String TRACE_HEADER = "X-Trace-Id";
    private static final String MDC_TRACE_KEY = "traceId";

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String traceId = Span.current().getSpanContext().getTraceId();

        if (traceId != null && !traceId.isBlank()) {
            response.setHeader(TRACE_HEADER, traceId);
            MDC.put(MDC_TRACE_KEY, traceId);
        }

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(MDC_TRACE_KEY);
        }
    }
}