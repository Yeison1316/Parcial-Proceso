package com.ufpso.tienda.user.service;

import com.ufpso.tienda.article.exceptions.AuthenticationFailedException;
import com.ufpso.tienda.article.exceptions.CustomResponseHandler;
import com.ufpso.tienda.article.model.enums.ErrorMessages;
import com.ufpso.tienda.user.model.User;
import com.ufpso.tienda.user.model.dto.AuthRequest;
import com.ufpso.tienda.user.model.dto.AuthResponse;
import com.ufpso.tienda.user.model.dto.ResponseUser;
import com.ufpso.tienda.user.repository.UserRepository;
import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserRepository userRepository, AuthenticationManager  authenticationManager, JWTService jwtService) {
        this.userRepository = userRepository;
        this.authenticationManager  = authenticationManager;
        this.jwtService = jwtService;
    }

    public AuthResponse login(AuthRequest authRequest){
        System.out.println(authRequest);
       /* try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authRequest.getEmail(), authRequest.getPassword()
            ));
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new AuthenticationFailedException(ErrorMessages.CREDENTIAL_INVALID.getMessage());
        }*/
        Optional<User> user = userRepository.findByEmail(authRequest.getEmail());
        if (user.isEmpty()){
            System.out.println("hola3");
            throw new AuthenticationFailedException(ErrorMessages.CREDENTIAL_INVALID.getMessage());
        }
        UserDetails userDetails = user.get();
        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
    public AuthResponse registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new AuthenticationFailedException("Email already registered");
        }
        User newUser = new User();
        newUser.setFullName(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(newUser);
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                savedUser.getEmail(),
                savedUser.getPassword(),
                Collections.emptyList()
        );
        String token = jwtService.getToken(userDetails);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
