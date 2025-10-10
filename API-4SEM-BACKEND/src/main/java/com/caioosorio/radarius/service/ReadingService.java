package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.reading.ReadingRequestDTO;
import com.caioosorio.radarius.dto.reading.ReadingResponseDTO;

import java.util.List;

public interface ReadingService {
    ReadingResponseDTO create(ReadingRequestDTO dto);
    ReadingResponseDTO update(Integer id, ReadingRequestDTO dto);
    void delete(Integer id);
    ReadingResponseDTO findById(Integer id);
    List<ReadingResponseDTO> findAll();
}
