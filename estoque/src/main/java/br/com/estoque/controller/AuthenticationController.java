package br.com.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.estoque.service.AuthenticationService;

@Controller
public class AuthenticationController {
	@Autowired
	private final AuthenticationService authenticationService;

	public AuthenticationController(final AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping("authenticate")
	public String authenticate(final Authentication authentication) {
		return this.authenticationService.authenticate(authentication);
	}
}