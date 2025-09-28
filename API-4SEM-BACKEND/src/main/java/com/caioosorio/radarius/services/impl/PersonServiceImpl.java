package com.caioosorio.radarius.service.impl;

import com.caioosorio.radarius.entity.Person;
import com.caioosorio.radarius.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.caioosorio.radarius.repository.PersonRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;

    public Optional<Person> findByEmail(String email) {
        return personRepository.findByEmail(email);
    }
}
