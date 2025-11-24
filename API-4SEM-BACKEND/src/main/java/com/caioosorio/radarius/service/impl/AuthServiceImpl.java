package com.caioosorio.radarius.service.impl;

import com.caioosorio.radarius.dto.login.LoginResponseDTO;
import com.caioosorio.radarius.security.JwtIssuer;
import com.caioosorio.radarius.security.UserPrincipal;
import com.caioosorio.radarius.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponseDTO login(String email, String password) {
        var auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(email, password));

        SecurityContextHolder.getContext().setAuthentication(auth);
        var userPrincipal = (UserPrincipal)auth.getPrincipal();

        var token = jwtIssuer.issue(
            userPrincipal.getUserId(),
            userPrincipal.getEmail(),
            userPrincipal.getRole().toString()
        );

        return new LoginResponseDTO(
                token,
                userPrincipal.getRole(),
                userPrincipal.getName(),
                userPrincipal.getEmail()
        );
    }
}
