package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dto.ReadingRequestDTO;
import com.caioosorio.radarius.dto.ReadingResponseDTO;

import java.util.List;

public interface ReadingService {

    List<ReadingResponseDTO> findAll();

    ReadingResponseDTO findById(Integer id);

    ReadingResponseDTO save(ReadingRequestDTO dto);

    ReadingResponseDTO update(Integer id, ReadingRequestDTO dto);

    void delete(Integer id);
}
