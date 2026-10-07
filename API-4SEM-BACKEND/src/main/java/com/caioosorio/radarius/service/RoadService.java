package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.road.RoadRequestDTO;
import com.caioosorio.radarius.dto.road.RoadResponseDTO;

import java.util.List;

public interface RoadService {
    RoadResponseDTO create(RoadRequestDTO dto);
    RoadResponseDTO update(Integer id, RoadRequestDTO dto);
    void delete(Integer id);
    RoadResponseDTO findById(Integer id);
    List<RoadResponseDTO> findAll();
}
