package com.caioosorio.radarius.repository;

import com.caioosorio.radarius.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Integer> {
    Optional<Camera> findByLatitudeAndLongitude(BigDecimal latitude, BigDecimal longitude);
}
