package com.algaworks.algaworksapi.domain.repository;

import com.algaworks.algaworksapi.domain.model.Cozinha;

import javax.persistence.Id;
import java.util.List;

public interface CozinhaRepository {
    List<Cozinha> listar();
    Cozinha buscar (Long id);
    Cozinha salvar (Cozinha cozinha);
    void remover (Long id);
}
