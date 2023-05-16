package com.project.LibraryManagement.util;

import org.springframework.stereotype.Component;
import java.util.*;
import com.project.LibraryManagement.entity.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {

	private static String secret = "This is secret";
	public String generateJwt(Users user) {
	    long milliTime = System.currentTimeMillis();
	    long tenMinuteInMills = 10 * 60 * 1000;
	    long ExpireTime = milliTime + tenMinuteInMills;
		Date issueAt = new Date(milliTime);
		Date ExpireAt = new Date (ExpireTime);
		
		// claims
		Claims claims = Jwts.claims()
				.setIssuer(user.getUserId().toString())
				.setIssuedAt(issueAt)
				.setExpiration(ExpireAt);
		
		
		claims.put("type", user.getUserType());
		claims.put("name", user.getUserName());
		claims.put("email", user.getEmail());
		// generate token using claims
		
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
		
	}
	
	public void verify(String authization) throws Exception {
	
		try {
		Jwts.parser().setSigningKey(secret).parseClaimsJws(authization);
		}
		catch(Exception e) {
			throw new Exception();
		}
		}
}
