package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dto.CriterionLevelRequestDTO;
import com.caioosorio.radarius.dto.CriterionLevelResponseDTO;

import java.util.List;

public interface CriterionLevelService {

    List<CriterionLevelResponseDTO> findAll();

    CriterionLevelResponseDTO findById(Integer id);

    CriterionLevelResponseDTO save(CriterionLevelRequestDTO dto);

    CriterionLevelResponseDTO update(Integer id, CriterionLevelRequestDTO dto);

    void delete(Integer id);
}
