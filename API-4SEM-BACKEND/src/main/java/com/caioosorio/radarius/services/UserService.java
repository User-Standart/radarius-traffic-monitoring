package com.caioosorio.radarius.services;

import com.caioosorio.radarius.dtos.user.UserRequestDTO;
import com.caioosorio.radarius.dtos.user.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> findAll();

    UserResponseDTO findById(Integer id);

    UserResponseDTO save(UserRequestDTO dto);

    UserResponseDTO update(Integer id, UserRequestDTO dto);

    void delete(Integer id);
}
