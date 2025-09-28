package com.caioosorio.radarius.repositories;

import com.caioosorio.radarius.entity.Road;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoadRepository extends JpaRepository<Road, Integer> {
}
