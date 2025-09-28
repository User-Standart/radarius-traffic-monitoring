package com.caioosorio.radarius.service.impl;

import com.caioosorio.radarius.dto.login.LoginResponseDTO;
import com.caioosorio.radarius.security.JwtIssuer;
import com.caioosorio.radarius.security.UserPrincipal;
import com.caioosorio.radarius.services.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    public LoginResponseDTO login(String email, String password) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        var userPrincipal = (UserPrincipal)auth.getPrincipal();
        var token = jwtIssuer.issue(userPrincipal.getUserId(), userPrincipal.getEmail());
        return new LoginResponseDTO(token);
    }
}
