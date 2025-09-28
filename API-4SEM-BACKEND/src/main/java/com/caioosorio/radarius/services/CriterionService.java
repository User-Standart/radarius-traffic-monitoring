package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dto.CriterionRequestDTO;
import com.caioosorio.radarius.dto.CriterionResponseDTO;

import java.util.List;

public interface CriterionService {

    List<CriterionResponseDTO> findAll();

    CriterionResponseDTO findById(Integer id);

    CriterionResponseDTO save(CriterionRequestDTO dto);

    CriterionResponseDTO update(Integer id, CriterionRequestDTO dto);

    void delete(Integer id);
}
