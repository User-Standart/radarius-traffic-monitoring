package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.person.PersonRequestDTO;
import com.caioosorio.radarius.dto.person.PersonResponseDTO;

import java.util.List;

public interface PersonService {
    PersonResponseDTO create(PersonRequestDTO dto);
    PersonResponseDTO update(Integer id, PersonRequestDTO dto);
    void delete(Integer id);
    PersonResponseDTO findById(Integer id);
    List<PersonResponseDTO> findAll();
}
