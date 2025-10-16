package com.caioosorio.radarius.service.impl;

import com.caioosorio.radarius.dto.alertlog.AlertLogResponseDTO;
import com.caioosorio.radarius.entity.Alert;
import com.caioosorio.radarius.entity.AlertLog;
import com.caioosorio.radarius.entity.Criterion;
import com.caioosorio.radarius.entity.Region;
import com.caioosorio.radarius.repository.AlertLogRepository;
import com.caioosorio.radarius.repository.AlertRepository;
import com.caioosorio.radarius.repository.RegionRepository;
import com.caioosorio.radarius.service.AlertLogService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertLogServiceImpl implements AlertLogService {

    @Autowired
    private AlertLogRepository alertLogRepository;
    @Autowired
    private AlertRepository alertRepository;
    @Autowired
    private RegionRepository regionRepository;

    @Override
    public AlertLog create(Short newLevel, Criterion criterion, Region region) {
        AlertLog newAlertLog = AlertLog.builder()
                .region(region)
                .criterion(criterion)
                .newLevel(newLevel)
                .createdAt(LocalDateTime.now())
                .build();

        AlertLog previousAlertLog = alertLogRepository.findLatestByRegion(region.getId())
                .orElse(null);

        Alert alert = alertRepository.findLatestAlertByCriterionAndRegion(criterion.getId(), region.getId())
                .orElseThrow(() -> new EntityNotFoundException("Alert não encontrado para o critério e região fornecidos"));

        if (alert.getClosedAt() == null) newAlertLog.setAlert(alert);

        if (previousAlertLog != null) {
            newAlertLog.setPreviousLevel(previousAlertLog.getNewLevel());
            if (newAlertLog.getPreviousLevel() < newAlertLog.getNewLevel()) {
                alertRepository.save(Alert.builder()
                    .message("Queda de nível na região " +
                        region.getName() +
                        " para o critério " +
                        criterion.getName())
                    .level(newLevel)
                    .createdAt(LocalDateTime.now())
                    .region(region)
                    .criterion(criterion)
                    .build()
                );
            }
        }
        return alertLogRepository.save(newAlertLog);
    }

    @Override
    public void delete(Integer id) {
        alertLogRepository.deleteById(id);
    }

    @Override
    public AlertLogResponseDTO findById(Integer id) {
        return alertLogRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("AlertLog não encontrado"));
    }

    @Override
    public List<AlertLogResponseDTO> findAll() {
        return alertLogRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private AlertLogResponseDTO mapToDTO(AlertLog alertLog) {
        AlertLogResponseDTO dto = new AlertLogResponseDTO();
        dto.setId(alertLog.getId());
        dto.setCreatedAt(alertLog.getCreatedAt());
        dto.setPreviousLevel(alertLog.getPreviousLevel());
        dto.setNewLevel(alertLog.getNewLevel());
        dto.setClosedAt(alertLog.getClosedAt());
        dto.setAlertMessage(alertLog.getAlert() != null ? alertLog.getAlert().getMessage() : null);
        dto.setRegionName(alertLog.getRegion() != null ? alertLog.getRegion().getName() : null);
        return dto;
    }
}
