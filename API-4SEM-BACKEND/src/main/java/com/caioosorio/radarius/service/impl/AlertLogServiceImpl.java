package com.caioosorio.radarius.service.impl;

import com.caioosorio.radarius.entity.Alert;
import com.caioosorio.radarius.entity.AlertLog;
import com.caioosorio.radarius.entity.Criterion;
import com.caioosorio.radarius.entity.Region;
import com.caioosorio.radarius.repository.AlertLogRepository;
import com.caioosorio.radarius.repository.AlertRepository;
import com.caioosorio.radarius.service.AlertLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AlertLogServiceImpl implements AlertLogService {

    @Autowired
    private AlertLogRepository alertLogRepository;
    @Autowired
    private AlertRepository alertRepository;

    @Override
    public AlertLog create(Short newLevel, Criterion criterion, Region region) {
        AlertLog newAlertLog = AlertLog.builder()
                .region(region)
                .criterion(criterion)
                .newLevel(newLevel)
                .createdAt(LocalDateTime.now())
                .build();

        AlertLog previousAlertLog = alertLogRepository
                .findFirstByCriterionIdAndRegionIdOrderByCreatedAtDesc(criterion.getId(), region.getId())
                .orElse(null);
        Short previousLevel = previousAlertLog == null ? 1 : previousAlertLog.getNewLevel();
        newAlertLog.setPreviousLevel(previousLevel);

        Alert alert = alertRepository
                .findFirstByCriterionIdAndRegionIdOrderByCreatedAtDesc(criterion.getId(), region.getId())
                .orElse(null);

        if (alert != null) {
            if (alert.getClosedAt() == null) newAlertLog.setAlert(alert);
            else if (newAlertLog.getNewLevel() > newAlertLog.getPreviousLevel() && previousAlertLog != null) {
                Alert newAlert = alertRepository.save(Alert.builder()
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
                newAlertLog.setAlert(newAlert);
            }
        }

        return alertLogRepository.save(newAlertLog);
    }

    @Override
    public void delete(Integer id) {
        alertLogRepository.deleteById(id);
    }
}
