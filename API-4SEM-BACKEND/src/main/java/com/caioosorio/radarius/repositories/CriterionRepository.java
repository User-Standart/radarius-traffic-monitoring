package com.caioosorio.radarius.repository;

import com.caioosorio.radarius.entity.Criterion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriterionRepository extends JpaRepository<Criterion, Integer> {
}
