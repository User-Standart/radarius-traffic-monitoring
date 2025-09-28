package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dtos.protocol.ProtocolRequestDTO;
import com.caioosorio.radarius.dtos.protocol.ProtocolResponseDTO;

import java.util.List;

public interface ProtocolService {

    List<ProtocolResponseDTO> findAll();

    ProtocolResponseDTO findById(Integer id);

    ProtocolResponseDTO save(ProtocolRequestDTO dto);

    ProtocolResponseDTO update(Integer id, ProtocolRequestDTO dto);

    void delete(Integer id);
}
