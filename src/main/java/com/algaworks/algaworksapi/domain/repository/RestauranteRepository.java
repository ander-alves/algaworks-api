package com.algaworks.algaworksapi.domain.repository;

import com.algaworks.algaworksapi.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {
}
