package com.caioosorio.radarius.repository;

import com.caioosorio.radarius.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
