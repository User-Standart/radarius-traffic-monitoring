package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.region.RegionRequestDTO;
import com.caioosorio.radarius.dto.region.RegionResponseDTO;

import java.util.List;

public interface RegionService {
    RegionResponseDTO create(RegionRequestDTO dto);
    RegionResponseDTO update(Integer id, RegionRequestDTO dto);
    void delete(Integer id);
    RegionResponseDTO findById(Integer id);
    List<RegionResponseDTO> findAll();
}
