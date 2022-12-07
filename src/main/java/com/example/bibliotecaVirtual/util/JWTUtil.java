package com.example.bibliotecaVirtual.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {
	public static final String SECRETKEY= "clave";
	
	public static String getToken(String nombreUsuario, String roles) {
		List<GrantedAuthority> autoridadesacepatadas = AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
		String jwt = Jwts.builder()
				.setId("JWT"+nombreUsuario)
				.setSubject(nombreUsuario)
				.claim("authorities", autoridadesacepatadas.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+30000))
				.signWith(SignatureAlgorithm.HS512, SECRETKEY.getBytes())
				.compact();
		return jwt;
		
	}

}
