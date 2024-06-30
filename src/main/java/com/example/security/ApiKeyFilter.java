package com.example.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    @Autowired
    @Value("${API_KEY}")
    private String apiKey;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String requestPath = request.getRequestURI();

        if (requestPath.startsWith("/api/stocks") && "GET".equalsIgnoreCase(request.getMethod())) {
            filterChain.doFilter(request, response);
            return;
        }

        String hasKeyHeader = request.getHeader("Authorization");

        if(hasKeyHeader == null || !hasKeyHeader.equals(apiKey)){
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().write("Unauthorized");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
