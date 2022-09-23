package com.algaworks.algaworksapi.domain.repository;

import com.algaworks.algaworksapi.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepositry {
    List<Cozinha> listar();
    Cozinha buscar (Long id);
    Cozinha salvar (Cozinha cozinha);
    void remover (Cozinha cozinha);
}
