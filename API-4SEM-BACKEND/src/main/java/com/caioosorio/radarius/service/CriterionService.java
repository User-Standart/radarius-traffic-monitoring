package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.criterion.CriterionRequestDTO;
import com.caioosorio.radarius.dto.criterion.CriterionResponseDTO;

import java.util.List;

public interface CriterionService {
    CriterionResponseDTO create(CriterionRequestDTO dto);
    CriterionResponseDTO update(Integer id, CriterionRequestDTO dto);
    void delete(Integer id);
    CriterionResponseDTO findById(Integer id);
    List<CriterionResponseDTO> findAll();
    List<CriterionResponseDTO> getCriteriaSummary();
}
