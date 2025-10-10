package com.caioosorio.radarius.service.impl;

import com.caioosorio.radarius.dto.detectedincident.DetectedIncidentRequestDTO;
import com.caioosorio.radarius.dto.detectedincident.DetectedIncidentResponseDTO;
import com.caioosorio.radarius.entity.Alert;
import com.caioosorio.radarius.entity.DetectedIncident;
import com.caioosorio.radarius.entity.Person;
import com.caioosorio.radarius.repository.AlertRepository;
import com.caioosorio.radarius.repository.DetectedIncidentRepository;
import com.caioosorio.radarius.repository.PersonRepository;
import com.caioosorio.radarius.service.DetectedIncidentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetectedIncidentServiceImpl implements DetectedIncidentService {

    @Autowired
    private DetectedIncidentRepository detectedIncidentRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AlertRepository alertRepository;

    @Override
    public DetectedIncidentResponseDTO create(DetectedIncidentRequestDTO dto) {
        DetectedIncident di = mapToEntity(dto);
        return mapToDTO(detectedIncidentRepository.save(di));
    }

    @Override
    public DetectedIncidentResponseDTO update(Integer id, DetectedIncidentRequestDTO dto) {
        DetectedIncident di = detectedIncidentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DetectedIncident não encontrado"));
        updateEntity(di, dto);
        return mapToDTO(detectedIncidentRepository.save(di));
    }

    @Override
    public void delete(Integer id) {
        detectedIncidentRepository.deleteById(id);
    }

    @Override
    public DetectedIncidentResponseDTO findById(Integer id) {
        return detectedIncidentRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("DetectedIncident não encontrado"));
    }

    @Override
    public List<DetectedIncidentResponseDTO> findAll() {
        return detectedIncidentRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private DetectedIncident mapToEntity(DetectedIncidentRequestDTO dto) {
        DetectedIncident di = new DetectedIncident();
        updateEntity(di, dto);
        return di;
    }

    private void updateEntity(DetectedIncident di, DetectedIncidentRequestDTO dto) {
        di.setIncidentType(dto.getIncidentType());
        di.setCreatedAt(dto.getCreatedAt());

        if (dto.getCreatedById() != null)
            di.setCreatedBy(personRepository.findById(dto.getCreatedById()).orElse(null));

        if (dto.getAlertId() != null)
            di.setAlert(alertRepository.findById(dto.getAlertId()).orElse(null));
    }

    private DetectedIncidentResponseDTO mapToDTO(DetectedIncident di) {
        DetectedIncidentResponseDTO dto = new DetectedIncidentResponseDTO();
        dto.setId(di.getId());
        dto.setIncidentType(di.getIncidentType());
        dto.setCreatedAt(di.getCreatedAt());
        dto.setCreatedByName(di.getCreatedBy() != null ? di.getCreatedBy().getName() : null);
        dto.setAlertMessage(di.getAlert() != null ? di.getAlert().getMessage() : null);
        return dto;
    }
}
