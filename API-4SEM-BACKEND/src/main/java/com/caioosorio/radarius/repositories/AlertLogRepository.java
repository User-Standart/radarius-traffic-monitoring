package com.caioosorio.radarius.repositories;

import com.caioosorio.radarius.entity.AlertLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertLogRepository extends JpaRepository<AlertLog, Integer> {
}
