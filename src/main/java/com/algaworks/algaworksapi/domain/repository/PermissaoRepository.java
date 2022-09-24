package com.algaworks.algaworksapi.domain.repository;

import java.util.List;

import com.algaworks.algaworksapi.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> listar();
	Permissao buscar(Long id);
	Permissao salvar(Permissao permissao);
	void remover(Permissao permissao);
	
}
