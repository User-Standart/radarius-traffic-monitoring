package com.caioosorio.radarius.service;

import com.caioosorio.radarius.entity.AlertLog;

public interface AlertNotificationService {
    void notifyAlertLogCreated(AlertLog alertLog);
}
