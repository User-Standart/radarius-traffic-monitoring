package com.caioosorio.radarius.repositories;

import com.caioosorio.radarius.entity.Protocol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProtocolRepository extends JpaRepository<Protocol, Integer> {
}
