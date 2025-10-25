package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.protocol.ProtocolRequestDTO;
import com.caioosorio.radarius.dto.protocol.ProtocolResponseDTO;

import java.util.List;

public interface ProtocolService {
    ProtocolResponseDTO create(ProtocolRequestDTO dto);
    ProtocolResponseDTO update(Integer id, ProtocolRequestDTO dto);
    void delete(Integer id);
    ProtocolResponseDTO findById(Integer id);
    List<ProtocolResponseDTO> findAll();
    List<ProtocolResponseDTO> search(String query);
}
