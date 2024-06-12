package com.ufpso.tienda.user.controller;

import com.ufpso.tienda.user.model.User;
import com.ufpso.tienda.user.model.dto.AuthRequest;
import com.ufpso.tienda.user.model.dto.AuthResponse;
import com.ufpso.tienda.user.service.AuthService;
import com.ufpso.tienda.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest authRequest){
        AuthResponse res = service.login(authRequest);
        return ResponseEntity.ok(res);
    }
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> registerUser(@Valid @RequestBody User user) {
        AuthResponse res = service.registerUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
