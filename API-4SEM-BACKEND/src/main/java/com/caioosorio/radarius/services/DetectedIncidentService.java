package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dtos.detectedincident.DetectedIncidentRequestDTO;
import com.caioosorio.radarius.dtos.detectedincident.DetectedIncidentResponseDTO;

import java.util.List;

public interface DetectedIncidentService {

    List<DetectedIncidentResponseDTO> findAll();

    DetectedIncidentResponseDTO findById(Integer id);

    DetectedIncidentResponseDTO save(DetectedIncidentRequestDTO dto);

    DetectedIncidentResponseDTO update(Integer id, DetectedIncidentRequestDTO dto);

    void delete(Integer id);
}
