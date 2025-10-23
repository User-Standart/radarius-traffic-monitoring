package com.caioosorio.radarius.repository;

import com.caioosorio.radarius.entity.Criterion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CriterionRepository extends JpaRepository<Criterion, Integer> {
    Optional<Criterion> findByName(String name);
}
