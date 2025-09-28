package com.caioosorio.radarius.repositories;

import com.caioosorio.radarius.entity.Person;
import org.springframework.data.jpa.repositories.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByEmail(String email);
}
