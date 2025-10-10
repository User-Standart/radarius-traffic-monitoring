package com.caioosorio.radarius.repository;

import com.caioosorio.radarius.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Integer> {
}
