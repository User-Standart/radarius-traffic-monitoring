package com.caioosorio.radarius.service;

import com.caioosorio.radarius.entity.Person;

import java.util.Optional;

public interface PersonService {
    Optional<Person> findByEmail(String email);
}
