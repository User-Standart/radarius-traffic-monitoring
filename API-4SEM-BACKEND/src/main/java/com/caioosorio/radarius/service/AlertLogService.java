package com.caioosorio.radarius.service;

import com.caioosorio.radarius.entity.AlertLog;
import com.caioosorio.radarius.entity.Criterion;
import com.caioosorio.radarius.entity.Region;


public interface AlertLogService {
    AlertLog create(Short newLevel, Criterion criterion, Region region);
    void delete(Integer id);
}
