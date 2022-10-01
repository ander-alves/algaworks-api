package com.algaworks.algaworksapi.domain.repository;

import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.model.Restaurante;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RestauranteRepositry {
    List<Restaurante> listar();
    Restaurante buscar (Long id);
    Restaurante salvar (Restaurante restaurante);
    void remover (Restaurante restaurante);

    @Transactional
    void remover(Long id);
}
