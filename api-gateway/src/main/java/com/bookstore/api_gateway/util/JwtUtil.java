package com.bookstore.api_gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

/**
 * Utility class for JWT validation
 */
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    /**
     * This method runs once when the application starts
     * Used to verify if JWT secret is loaded correctly
     */
    @PostConstruct
    public void check() {
        System.out.println("JWT SECRET = " + secret);
    }

    /**
     * Validate JWT token and return claims
     */
    public Claims validateToken(String token) {

        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}