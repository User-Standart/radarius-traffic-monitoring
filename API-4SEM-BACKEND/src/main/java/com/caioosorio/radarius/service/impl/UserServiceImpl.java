package com.caioosorio.radarius.service.impl;

import com.caioosorio.radarius.entity.User;
import com.caioosorio.radarius.service.UserService;
import org.springframework.stereotype.Service;
import com.caioosorio.radarius.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
