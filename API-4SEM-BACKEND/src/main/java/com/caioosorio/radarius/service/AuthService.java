package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.login.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(String email, String password);
}
