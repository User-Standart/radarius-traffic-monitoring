package com.caioosorio.radarius.dto.login;

import com.caioosorio.radarius.enums.RoleEnum;

public record LoginResponseDTO(
        String token,
        RoleEnum role,
        String name,
        String email
) {}
