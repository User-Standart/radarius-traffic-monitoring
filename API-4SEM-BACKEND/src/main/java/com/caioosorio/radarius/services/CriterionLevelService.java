package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dtos.criterionlevel.CriterionLevelRequestDTO;
import com.caioosorio.radarius.dtos.criterionlevel.CriterionLevelResponseDTO;

import java.util.List;

public interface CriterionLevelService {

    List<CriterionLevelResponseDTO> findAll();

    CriterionLevelResponseDTO findById(Integer id);

    CriterionLevelResponseDTO save(CriterionLevelRequestDTO dto);

    CriterionLevelResponseDTO update(Integer id, CriterionLevelRequestDTO dto);

    void delete(Integer id);
}
