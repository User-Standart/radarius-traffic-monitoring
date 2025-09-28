package com.caioosorio.radarius.repositories;

import com.caioosorio.radarius.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends JpaRepository<Reading, Integer> {
}
