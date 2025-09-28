package com.caioosorio.radarius.service;

import com.caioosorio.radarius.dto.UserRequestDTO;
import com.caioosorio.radarius.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> findAll();

    UserResponseDTO findById(Integer id);

    UserResponseDTO save(UserRequestDTO dto);

    UserResponseDTO update(Integer id, UserRequestDTO dto);

    void delete(Integer id);
}
