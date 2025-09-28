package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dtos.request.AlertRequestDTO;
import com.caioosorio.radarius.entity.Alert;

import java.util.List;
import java.util.Optional;

public interface AlertService {

    List<Alert> findAll();

    Optional<Alert> findById(Integer id);

    Alert save(AlertRequestDTO alertRequest);

    Alert update(Integer id, AlertRequestDTO alertRequest);

    void delete(Integer id);
}
