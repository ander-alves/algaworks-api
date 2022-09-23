package com.algaworks.algaworksapi.domain.repository;

import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepositry {
    List<Restaurante> listar();
    Restaurante buscar (Long id);
    Restaurante salvar (Restaurante restaurante);
    void remover (Restaurante restaurante);
}
