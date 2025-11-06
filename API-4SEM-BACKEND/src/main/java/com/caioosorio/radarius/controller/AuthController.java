package com.caioosorio.radarius.controller;

import com.caioosorio.radarius.dto.login.LoginRequestDTO;
import com.caioosorio.radarius.dto.login.LoginResponseDTO;
import com.caioosorio.radarius.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.AuthenticationException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) throws javax.naming.AuthenticationException {
        try {
            LoginResponseDTO response = authService.login(dto.email(), dto.password());
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.UNAUTHORIZED,
                "Falha na autenticação: E-mail ou senha inválidos. Por favor, verifique suas credenciais."
            );
            problemDetail.setTitle("Unauthorized");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(problemDetail);
        }
    }
}
