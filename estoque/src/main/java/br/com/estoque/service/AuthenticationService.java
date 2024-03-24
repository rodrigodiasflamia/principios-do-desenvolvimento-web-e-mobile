package br.com.estoque.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	private final JwtService jwtService;

	public AuthenticationService(final JwtService jwtService) {
		this.jwtService = jwtService;
	}

	public String authenticate(final Authentication authentication) {
		return this.jwtService.generateToken(authentication);
	}
}