package com.caioosorio.radarius.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.caioosorio.radarius.enums.RoleEnum;
import org.springframework.stereotype.Component;

@Component
public class JwtToPrincipalConverter {
    public static UserPrincipal convert(DecodedJWT jwt) {
        return UserPrincipal.builder()
                .userId(Integer.valueOf(jwt.getSubject()))
                .email(jwt.getClaim("e").asString())
                .role(RoleEnum.valueOf(jwt.getClaim("r").asString()))
                .build();
    }
}
