package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dtos.road.RoadRequestDTO;
import com.caioosorio.radarius.dtos.road.RoadResponseDTO;

import java.util.List;

public interface RoadService {

    List<RoadResponseDTO> findAll();

    RoadResponseDTO findById(Integer id);

    RoadResponseDTO save(RoadRequestDTO dto);

    RoadResponseDTO update(Integer id, RoadRequestDTO dto);

    void delete(Integer id);
}
