package com.loanapp.loanManagementSystem.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final SecretKey secretKey;

    public CustomAuthenticationEntryPoint(@Value("${jwt.secret}") String secret) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException, ServletException {


        String token = extractToken(request);


        Map<String, String> tokenInfo = getTokenInfo(token);


        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now().toString());
        errorResponse.put("status", 401);
        errorResponse.put("error", "Unauthorized");
        errorResponse.put("message", tokenInfo.get("message"));
        errorResponse.put("path", request.getRequestURI());
        errorResponse.put("tokenType", tokenInfo.get("tokenType"));
        errorResponse.put("tokenStatus", tokenInfo.get("tokenStatus"));


        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(errorResponse));
    }

    private String extractToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }
        return null;
    }

    private Map<String, String> getTokenInfo(String token) {
        Map<String, String> info = new HashMap<>();

        if (token == null || token.trim().isEmpty()) {
            info.put("tokenType", "NONE");
            info.put("tokenStatus", "MISSING");
            info.put("message", "Authentication failed: No token provided. Please provide a valid JWT token.");
            return info;
        }

        try {

            Claims claims = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();


            String tokenType = extractTokenType(claims);
            info.put("tokenType", tokenType);
            info.put("tokenStatus", "VALID");
            info.put("message", "Authentication failed: Token is valid but authentication failed.");

        } catch (ExpiredJwtException e) {

            Claims claims = e.getClaims();
            String tokenType = extractTokenType(claims);
            info.put("tokenType", tokenType);
            info.put("tokenStatus", "EXPIRED");
            info.put("message", String.format("Authentication failed: %s token has expired. Please login again to get a new token.", tokenType));

        } catch (JwtException e) {

            info.put("tokenType", "UNKNOWN");
            info.put("tokenStatus", "INVALID");
            info.put("message", "Authentication failed: Invalid or malformed token. Please provide a valid JWT token.");

        } catch (Exception e) {

            info.put("tokenType", "UNKNOWN");
            info.put("tokenStatus", "ERROR");
            info.put("message", "Authentication failed: Unable to process token.");
        }

        return info;
    }

    @SuppressWarnings("unchecked")
    private String extractTokenType(Claims claims) {
        try {
            List<String> roles = claims.get("roles", List.class);
            if (roles != null) {
                if (roles.contains("ADMIN")) {
                    return "ADMIN";
                } else if (roles.contains("USER")) {
                    return "USER";
                }
            }
            return "UNKNOWN";
        } catch (Exception e) {
            return "UNKNOWN";
        }
    }
}
