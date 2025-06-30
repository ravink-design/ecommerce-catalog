package com.example.ecommerce.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	//Encrypt or store in valt like Hashicorp Valt
	private static final String SECRET = "this_is_secret_not_to_store_in_plain_text";

	private final SecretKey secretKey = Keys.hmacShaKeyFor(SECRET.getBytes());

	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuer("EcommerceApp").setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
				.signWith(secretKey, SignatureAlgorithm.HS256).compact();
	}

	public String extractUsername(String token) {
		return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
			return true;
		} catch (JwtException e) {
			return false;
		}
	}
}
