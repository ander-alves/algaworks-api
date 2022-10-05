package com.algaworks.algaworksapi.domain.repository;

import com.algaworks.algaworksapi.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface RestauranteRepositry extends JpaRepository<Restaurante,Long> {
}
