package com.cognizant.smartshopauthentication.security;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class JwtAuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationController.class);

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {

		String user = getUser(authHeader);
		LOGGER.info("start");
		LOGGER.debug(user);
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		String tok = generateJwt(user);
		Map<String, String> hm = new HashMap<String, String>();
		hm.put("token", tok);
		hm.put("role", role);
		hm.put("username", user);
		return hm;

	}

	private static String getUser(String authHeader) {
		String encodedCredentials = authHeader.substring(6);
		byte[] decoded = Base64.getDecoder().decode(encodedCredentials);
		String pair = new String(decoded);
		String[] userDetails = pair.split(":", 2);
		return userDetails[0];

	}

	private static String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		// Set the token issue time as current time
		builder.setIssuedAt(new Date());

		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 120000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();

		return token;
	}

}
