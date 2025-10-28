package com.caioosorio.radarius.repository;

import com.caioosorio.radarius.entity.Protocol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Integer> {
    List<Protocol> findByNameContainingIgnoreCase(String query);
}
