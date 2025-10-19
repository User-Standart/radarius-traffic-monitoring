package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.CriterionCalculationResult;
import com.caioosorio.radarius.entity.Camera;
import com.caioosorio.radarius.entity.Criterion;

import java.util.List;
import java.util.Map;

public interface CriterionCalculationService {
    Map<Camera, List<CriterionCalculationResult>> calculateAndDetectLevelChanges();
    List<CriterionCalculationResult> calculateAllCriteriaForCamera(Camera camera);
    CriterionCalculationResult calculateCriterionForCamera(Criterion criterion, Camera camera);
    CriterionCalculationResult calculateCongestion(Camera camera);
    CriterionCalculationResult calculateVehicleDensity(Camera camera);
    CriterionCalculationResult calculateLargeVehicleCirculation(Camera camera);
    CriterionCalculationResult calculateSpeedViolations(Camera camera);
    Integer calculateAlertLevel(String criterionName, Double calculatedValue);
}
