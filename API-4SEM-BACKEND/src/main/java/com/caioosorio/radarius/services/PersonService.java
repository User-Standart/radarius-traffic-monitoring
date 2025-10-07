package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dtos.person.PersonRequestDTO;
import com.caioosorio.radarius.dtos.person.PersonResponseDTO;
import com.caioosorio.radarius.entity.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    List<PersonResponseDTO> findAll();

    PersonResponseDTO findById(Integer id);

    PersonResponseDTO save(PersonRequestDTO dto);

    PersonResponseDTO update(Integer id, PersonRequestDTO dto);

    void delete(Integer id);

    Optional<Person> findByEmail(String email);
}
