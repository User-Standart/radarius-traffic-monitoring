package com.caioosorio.radarius.repositories;

import com.caioosorio.radarius.entity.CriterionLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriterionLevelRepository extends JpaRepository<CriterionLevel, Integer> {
}
