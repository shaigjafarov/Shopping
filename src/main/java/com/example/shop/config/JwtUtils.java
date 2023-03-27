package com.example.shop.config;

import java.util.Base64;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${app.jwtSecret}")
  public String jwtSecret;

  @Value("${app.jwtExpirationInMs}")
  public Long jwtExpirationInMs;



  public String generateJwtToken(UserDetails userDetails) {
    long currentTimeMillis = System.currentTimeMillis();
    Date now = new Date(currentTimeMillis);
    Date expirationDate = new Date(currentTimeMillis + jwtExpirationInMs); // 5 minutes from now
    byte[] secretBytes = jwtSecret.getBytes();
    String base64Secret = Base64.getEncoder().encodeToString(secretBytes);

    return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setIssuedAt(now)
            .setExpiration(expirationDate)
            .signWith(SignatureAlgorithm.HS256, base64Secret)
            .compact();
  }

  public String getUserNameFromJwtToken(String token) {
    byte[] secretBytes = jwtSecret.getBytes();
    String base64Secret = Base64.getEncoder().encodeToString(secretBytes);
    return Jwts.parser().setSigningKey(base64Secret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      byte[] secretBytes = jwtSecret.getBytes();
      String base64Secret = Base64.getEncoder().encodeToString(secretBytes);
      Jwts.parser().setSigningKey(base64Secret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      logger.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      e.printStackTrace();
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
}