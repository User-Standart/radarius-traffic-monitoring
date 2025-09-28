package com.caioosorio.radarius.services;

import com.caioosorio.radarius.entity.Reading;

import java.util.List;
import java.util.Optional;

public interface ReadingService {

    List<Reading> findAll();

    Optional<Reading> findById(Integer id);

    Reading save(Reading reading);

    Reading update(Integer id, Reading reading);

    void delete(Integer id);
}
