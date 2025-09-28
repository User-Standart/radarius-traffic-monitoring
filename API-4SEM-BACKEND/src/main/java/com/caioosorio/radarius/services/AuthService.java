package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dtos.login.LoginResponseDTO;

import javax.naming.AuthenticationException;

public interface AuthService {
    LoginResponseDTO login(String email, String password) throws AuthenticationException;
}
