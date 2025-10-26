package com.caioosorio.radarius.service.impl;

import com.caioosorio.radarius.dto.criterionlevel.CriterionLevelRequestDTO;
import com.caioosorio.radarius.dto.criterionlevel.CriterionLevelResponseDTO;
import com.caioosorio.radarius.entity.CriterionLevel;
import com.caioosorio.radarius.repository.CriterionLevelRepository;
import com.caioosorio.radarius.repository.CriterionRepository;
import com.caioosorio.radarius.repository.PersonRepository;
import com.caioosorio.radarius.service.CriterionLevelService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CriterionLevelServiceImpl implements CriterionLevelService {

    @Autowired
    private CriterionLevelRepository criterionLevelRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CriterionRepository criterionRepository;

    @Override
    public CriterionLevelResponseDTO create(CriterionLevelRequestDTO dto) {
        CriterionLevel cl = mapToEntity(dto);
        return mapToDTO(criterionLevelRepository.save(cl));
    }

    @Override
    public CriterionLevelResponseDTO update(Integer id, CriterionLevelRequestDTO dto) {
        CriterionLevel cl = criterionLevelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CriterionLevel não encontrado"));
        updateEntity(cl, dto);
        return mapToDTO(criterionLevelRepository.save(cl));
    }

    @Override
    public void delete(Integer id) {
        criterionLevelRepository.deleteById(id);
    }

    @Override
    public CriterionLevelResponseDTO findById(Integer id) {
        return criterionLevelRepository.findById(id)
                .map(this::mapToDTO)
                .orElseThrow(() -> new EntityNotFoundException("CriterionLevel não encontrado"));
    }

    @Override
    public List<CriterionLevelResponseDTO> findAll() {
        return criterionLevelRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

        @Override
        public List<CriterionLevelResponseDTO> findByCriterionId(Integer criterionId) {
            return criterionLevelRepository.findByCriterion_Id(criterionId).stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }

    private CriterionLevel mapToEntity(CriterionLevelRequestDTO dto) {
        CriterionLevel cl = new CriterionLevel();
        updateEntity(cl, dto);
        return cl;
    }

    private void updateEntity(CriterionLevel cl, CriterionLevelRequestDTO dto) {
        cl.setLevel(dto.getLevel());
        cl.setCreatedAt(dto.getCreatedAt());

        if (dto.getCreatedById() != null)
            cl.setCreatedBy(personRepository.findById(dto.getCreatedById()).orElse(null));

        if (dto.getCriterionId() != null)
            cl.setCriterion(criterionRepository.findById(dto.getCriterionId()).orElse(null));
    }

    private CriterionLevelResponseDTO mapToDTO(CriterionLevel cl) {
        CriterionLevelResponseDTO dto = new CriterionLevelResponseDTO();
        dto.setId(cl.getId());
        dto.setLevel(cl.getLevel());
        dto.setCreatedAt(cl.getCreatedAt());
        dto.setCreatedByName(cl.getCreatedBy() != null ? cl.getCreatedBy().getName() : null);
        dto.setCriterionName(cl.getCriterion() != null ? cl.getCriterion().getName() : null);
        return dto;
    }
}
