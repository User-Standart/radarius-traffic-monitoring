package com.caioosorio.radarius.service;

import com.caioosorio.radarius.entity.User;

public interface UserService {
    User findByEmail(String email);
}
