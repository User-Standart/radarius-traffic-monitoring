// src/main/java/com/caioosorio/radarius/service/TrafficMetricsService.java
package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.metrics.AroundTimeVehiclesDTO;
import com.caioosorio.radarius.dto.metrics.HourlyVehiclesDTO;
import com.caioosorio.radarius.dto.metrics.RoadDailyAggregateDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TrafficMetricsService {
    List<HourlyVehiclesDTO> vehiclesPerHourForRoad(Integer regionId, Integer roadId, LocalDateTime start, LocalDateTime end);

    List<RoadDailyAggregateDTO> vehiclesPerHourByRoadForDay(Integer regionId, LocalDate date);

    // novo: intervalo (inclusivo em dias: start..end)
    List<RoadDailyAggregateDTO> vehiclesPerHourByRoadForRange(Integer regionId, LocalDate startDate, LocalDate endDate);

    AroundTimeVehiclesDTO vehiclesAroundTime(Integer regionId, Integer roadId, LocalDateTime targetTime, int windowMinutes);
}
