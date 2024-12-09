package com.library.Service;

import java.security.Key
;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.library.Config.JwtFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

	
	private String secretKey ="";
	
	public JWTService() {
		try {
			KeyGenerator keyGen =KeyGenerator.getInstance("HmacSHA256");
			SecretKey sk = keyGen.generateKey();
			secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	
	public String generateToken(String name) {

		Map<String, Object> claims = new HashMap<>();

		
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(name)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 60))
				.signWith(getKey())
				.compact();
	}

	private Key getKey() {
	     byte[] keyBytes =Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}


	public String extractName(String token) {
		return extractClaim(token, Claims::getSubject);
	}


	private <T> T extractClaim(String token,Function<Claims, T> claimResolver) {
		final Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}


	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
			    .setSigningKey(getKey())
			    .build()
			    .parseClaimsJws(token)
			    .getBody();
	}


	public boolean validateToken(String token, UserDetails userDetails) {
		return true;
	}

	

}
