package com.algaworks.algaworksapi.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.algaworks.algaworksapi.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, 
			BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}