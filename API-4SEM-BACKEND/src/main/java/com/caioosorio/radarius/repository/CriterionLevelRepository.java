package com.caioosorio.radarius.repository;

import com.caioosorio.radarius.entity.CriterionLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriterionLevelRepository extends JpaRepository<CriterionLevel, Integer> {
	List<CriterionLevel> findByCriterion_Id(Integer criterionId);
}
