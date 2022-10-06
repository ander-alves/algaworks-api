package com.algaworks.algaworksapi.domain.repository;

import com.algaworks.algaworksapi.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository <Permissao,Long> {
}
