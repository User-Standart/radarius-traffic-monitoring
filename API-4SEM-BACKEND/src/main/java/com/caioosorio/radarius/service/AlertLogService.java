package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.alertlog.AlertLogResponseDTO;
import com.caioosorio.radarius.entity.Alert;
import com.caioosorio.radarius.entity.AlertLog;
import com.caioosorio.radarius.entity.Criterion;
import com.caioosorio.radarius.entity.Region;

import java.util.List;

public interface AlertLogService {

    AlertLog create(Short newLevel, Criterion criterion, Region region);
    void delete(Integer id);
    AlertLog findById(Integer id);
    List<AlertLog> findByAlert(Alert alert);
}
