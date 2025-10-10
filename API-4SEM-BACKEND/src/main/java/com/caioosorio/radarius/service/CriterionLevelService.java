package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.criterionlevel.CriterionLevelRequestDTO;
import com.caioosorio.radarius.dto.criterionlevel.CriterionLevelResponseDTO;

import java.util.List;

public interface CriterionLevelService {
    CriterionLevelResponseDTO create(CriterionLevelRequestDTO dto);
    CriterionLevelResponseDTO update(Integer id, CriterionLevelRequestDTO dto);
    void delete(Integer id);
    CriterionLevelResponseDTO findById(Integer id);
    List<CriterionLevelResponseDTO> findAll();
}
