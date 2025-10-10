package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.alert.AlertRequestDTO;
import com.caioosorio.radarius.dto.alert.AlertResponseDTO;

import java.util.List;

public interface AlertService {
    AlertResponseDTO create(AlertRequestDTO dto);

    AlertResponseDTO update(Integer id, AlertRequestDTO dto);

    void delete(Integer id);

    AlertResponseDTO findById(Integer id);

    List<AlertResponseDTO> findAll();
}
