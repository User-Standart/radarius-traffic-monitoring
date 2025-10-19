package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.CriterionCalculationResult;
import com.caioosorio.radarius.entity.Alert;

import java.util.List;

public interface AdvancedAlertService {
    void processAllCriteriaAndGenerateAlerts();
    Alert createOrUpdateAlert(CriterionCalculationResult calculation);
    void deactivateOldAlerts();
    List<Alert> getActiveAlerts();
    List<Alert> getActiveAlertsByRegion(Integer regionId);
    List<Alert> getActiveAlertsByLevel(Integer level);
}
