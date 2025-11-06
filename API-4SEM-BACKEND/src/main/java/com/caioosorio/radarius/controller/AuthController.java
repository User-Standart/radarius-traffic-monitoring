package com.caioosorio.radarius.controller;

import com.caioosorio.radarius.dto.error.ErrorResponse;
import com.caioosorio.radarius.dto.login.LoginRequestDTO;
import com.caioosorio.radarius.dto.login.LoginResponseDTO;
import com.caioosorio.radarius.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {
        try {
            LoginResponseDTO response = authService.login(dto.email(), dto.password());
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(new ErrorResponse(
                "Unauthorized",
                "Usuário inexistente ou senha inválida",
                401
            ));
        }
    }
}
