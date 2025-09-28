package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dto.ProtocolRequestDTO;
import com.caioosorio.radarius.dto.ProtocolResponseDTO;

import java.util.List;

public interface ProtocolService {

    List<ProtocolResponseDTO> findAll();

    ProtocolResponseDTO findById(Integer id);

    ProtocolResponseDTO save(ProtocolRequestDTO dto);

    ProtocolResponseDTO update(Integer id, ProtocolRequestDTO dto);

    void delete(Integer id);
}
