package com.caioosorio.radarius.repository;

import com.caioosorio.radarius.entity.DetectedIncident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetectedIncidentRepository extends JpaRepository<DetectedIncident, Integer> {
}
