package com.caioosorio.radarius.service.criterion;

import com.caioosorio.radarius.dto.CriterionCalculationResult;
import com.caioosorio.radarius.entity.Camera;

public interface CriterionCalculator {
    CriterionCalculationResult calculate(Camera camera);
    String getCriterionName();
}