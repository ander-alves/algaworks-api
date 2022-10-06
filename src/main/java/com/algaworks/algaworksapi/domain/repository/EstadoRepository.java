package com.algaworks.algaworksapi.domain.repository;

import com.algaworks.algaworksapi.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
