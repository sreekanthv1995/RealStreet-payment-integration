package com.realstreet_payment_integration.realstreet.service.jwt;

import com.realstreet_payment_integration.realstreet.model.UserEntity;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.function.Function;

public interface JwtService {

    String extractUsername(String token);
    <T> T extractClaims(String token, Function<Claims,T> resolver);
    boolean isValid(String token, UserDetails userDetails);
    String generateToken(UserEntity user);
    boolean isTokenExpired(String token);

}
