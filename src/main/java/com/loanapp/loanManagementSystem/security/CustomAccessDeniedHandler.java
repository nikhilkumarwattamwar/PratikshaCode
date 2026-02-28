package com.loanapp.loanManagementSystem.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException
    ) throws IOException, ServletException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Determine user type
        boolean isAdmin = auth != null && auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
        boolean isUser = auth != null && auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ROLE_USER"));

        String userType = isAdmin ? "ADMIN" : isUser ? "USER" : "UNKNOWN";
        String message = getMessage(userType, request.getRequestURI());

        // Build minimal response
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now().toString());
        errorResponse.put("status", 403);
        errorResponse.put("error", "Forbidden");
        errorResponse.put("message", message);
        errorResponse.put("path", request.getRequestURI());
        errorResponse.put("tokenType", userType);  // Show token type

        // Send response
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json;charset=UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(errorResponse));
    }

    private String getMessage(String userType, String path) {
        if ("USER".equals(userType) && path.startsWith("/admin")) {
            return "Access Denied: This endpoint requires ADMIN role. Please use a valid ADMIN token.";
        } else if ("ADMIN".equals(userType)) {
            return "Access Denied: You don't have permission to access this resource.";
        } else {
            return "Access Denied: Invalid or insufficient permissions.";
        }
    }
}
