package com.store.onlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.onlinestore.dto.AuthenticationResponse;
import com.store.onlinestore.dto.LoginDto;
import com.store.onlinestore.dto.UserDto;
import com.store.onlinestore.service.AuthenticationService;

import jakarta.validation.Valid;

@CrossOrigin(
        origins =
                "https://cute-cobbler-7a8154.netlify.app",
        allowCredentials = "true"
)
@RequestMapping("/api")
@RestController
public class AuthController {
	
    @Autowired
	private AuthenticationService authService;
	
	@PostMapping(path = "/register")
	public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody UserDto userDto) {
		return ResponseEntity.ok(authService.register(userDto));
	}
	
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticateUser(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(authService.authenticate(loginDto));
    }
	
}
