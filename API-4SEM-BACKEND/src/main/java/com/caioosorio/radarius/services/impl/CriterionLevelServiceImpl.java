package com.caioosorio.radarius.services.impl;

import com.caioosorio.radarius.dtos.criterionlevel.CriterionLevelRequestDTO;
import com.caioosorio.radarius.dtos.criterionlevel.CriterionLevelResponseDTO;
import com.caioosorio.radarius.entity.Criterion;
import com.caioosorio.radarius.entity.CriterionLevel;
import com.caioosorio.radarius.entity.Person;
import com.caioosorio.radarius.repositories.CriterionLevelRepository;
import com.caioosorio.radarius.repositories.CriterionRepository;
import com.caioosorio.radarius.repositories.PersonRepository;
import com.caioosorio.radarius.services.CriterionLevelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CriterionLevelServiceImpl implements CriterionLevelService {

    private final CriterionLevelRepository repository;
    private final CriterionRepository criterionRepository;
    private final PersonRepository personRepository;

    public CriterionLevelServiceImpl(CriterionLevelRepository repository, CriterionRepository criterionRepository,
                                     PersonRepository personRepository) {
        this.repository = repository;
        this.criterionRepository = criterionRepository;
        this.personRepository = personRepository;
    }

    private CriterionLevelResponseDTO toDTO(CriterionLevel level) {
        CriterionLevelResponseDTO dto = new CriterionLevelResponseDTO();
        dto.setCriterionLevelId(level.getCriterionLevelId());
        dto.setCriterionId(level.getCriterion() != null ? level.getCriterion().getCriterionId() : null);
        dto.setLevel(level.getLevel());
        dto.setCreatedById(level.getCreatedBy() != null ? level.getCreatedBy().getPersonId() : null);
        dto.setCreatedAt(level.getCreatedAt());
        return dto;
    }

    private void mapDTOToEntity(CriterionLevelRequestDTO dto, CriterionLevel entity) {
        entity.setLevel(dto.getLevel());
        entity.setCreatedAt(dto.getCreatedAt());

        if (dto.getCriterionId() != null) {
            Criterion criterion = criterionRepository.findById(dto.getCriterionId())
                    .orElseThrow(() -> new RuntimeException("Criterion not found with id " + dto.getCriterionId()));
            entity.setCriterion(criterion);
        }

        if (dto.getCreatedById() != null) {
            Person person = personRepository.findById(dto.getCreatedById())
                    .orElseThrow(() -> new RuntimeException("User not found with id " + dto.getCreatedById()));
            entity.setCreatedBy(person);
        }
    }

    @Override
    public List<CriterionLevelResponseDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public CriterionLevelResponseDTO findById(Integer id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("CriterionLevel not found with id " + id));
    }

    @Override
    public CriterionLevelResponseDTO save(CriterionLevelRequestDTO dto) {
        CriterionLevel level = new CriterionLevel();
        mapDTOToEntity(dto, level);
        return toDTO(repository.save(level));
    }

    @Override
    public CriterionLevelResponseDTO update(Integer id, CriterionLevelRequestDTO dto) {
        CriterionLevel level = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("CriterionLevel not found with id " + id));
        mapDTOToEntity(dto, level);
        return toDTO(repository.save(level));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("CriterionLevel not found with id " + id);
        }
        repository.deleteById(id);
    }
}
