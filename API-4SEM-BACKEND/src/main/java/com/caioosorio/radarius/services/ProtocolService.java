package com.caioosorio.radarius.services;

import com.caioosorio.radarius.entity.Protocol;

import java.util.List;
import java.util.Optional;

public interface ProtocolService {

    List<Protocol> findAll();

    Optional<Protocol> findById(Integer id);

    Protocol save(Protocol protocol);

    Protocol update(Integer id, Protocol protocol);

    void delete(Integer id);
}
