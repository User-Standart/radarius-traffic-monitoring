package com.caioosorio.radarius.repository;

import com.caioosorio.radarius.entity.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoadRepository extends JpaRepository<Road, Integer> {
    Optional<Road> findByAddress(String address);
}
