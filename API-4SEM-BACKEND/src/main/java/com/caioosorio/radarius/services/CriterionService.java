package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dtos.criterion.CriterionRequestDTO;
import com.caioosorio.radarius.dtos.criterion.CriterionResponseDTO;

import java.util.List;

public interface CriterionService {

    List<CriterionResponseDTO> findAll();

    CriterionResponseDTO findById(Integer id);

    CriterionResponseDTO save(CriterionRequestDTO dto);

    CriterionResponseDTO update(Integer id, CriterionRequestDTO dto);

    void delete(Integer id);
}
