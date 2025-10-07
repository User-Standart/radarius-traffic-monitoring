package com.caioosorio.radarius.services.impl;

import com.caioosorio.radarius.dtos.protocol.ProtocolRequestDTO;
import com.caioosorio.radarius.dtos.protocol.ProtocolResponseDTO;
import com.caioosorio.radarius.entity.Protocol;
import com.caioosorio.radarius.entity.Person;
import com.caioosorio.radarius.repositories.ProtocolRepository;
import com.caioosorio.radarius.repositories.PersonRepository;
import com.caioosorio.radarius.services.ProtocolService;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProtocolServiceImpl implements ProtocolService {

    private final ProtocolRepository repository;
    private final PersonRepository personRepository;

    public ProtocolServiceImpl(ProtocolRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    private ProtocolResponseDTO toDTO(Protocol protocol) {
        ProtocolResponseDTO dto = new ProtocolResponseDTO();
        dto.setProtocolId(protocol.getProtocolId());
        dto.setName(protocol.getName());
        dto.setCreatedAt(protocol.getCreatedAt());
        dto.setCreatedById(protocol.getCreatedBy() != null ? protocol.getCreatedBy().getPersonId() : null);
        return dto;
    }

    private void mapDTOToEntity(ProtocolRequestDTO dto, Protocol entity) {
        entity.setName(dto.getName());
        entity.setCreatedAt(dto.getCreatedAt());

        if (dto.getCreatedById() != null) {
            Person person = personRepository.findById(dto.getCreatedById())
                    .orElseThrow(() -> new RuntimeException("Person not found with id " + dto.getCreatedById()));
            entity.setCreatedBy(person);
        }
    }

    @Override
    public List<ProtocolResponseDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProtocolResponseDTO findById(Integer id) {
        return repository.findById(id).map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Protocol not found with id " + id));
    }

    @Override
    public ProtocolResponseDTO save(ProtocolRequestDTO dto) {
        Protocol protocol = new Protocol();
        mapDTOToEntity(dto, protocol);
        return toDTO(repository.save(protocol));
    }

    @Override
    public ProtocolResponseDTO update(Integer id, ProtocolRequestDTO dto) {
        Protocol protocol = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Protocol not found with id " + id));
        mapDTOToEntity(dto, protocol);
        return toDTO(repository.save(protocol));
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Protocol not found with id " + id);
        }
        repository.deleteById(id);
    }
}
