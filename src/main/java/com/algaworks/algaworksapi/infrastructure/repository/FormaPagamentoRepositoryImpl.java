package com.algaworks.algaworksapi.infrastructure.repository;

import com.algaworks.algaworksapi.domain.model.FormaPagamento;
import com.algaworks.algaworksapi.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormaPagamento> listar() {
		return manager.createQuery("from FormaPagamento", FormaPagamento.class)
				.getResultList();
	}
	
	@Override
	public FormaPagamento buscar(Long id) {
		return manager.find(FormaPagamento.class, id);
	}
	
	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}
	
	@Transactional
	@Override
	public void remover(FormaPagamento formaPagamento) {
		formaPagamento = buscar(formaPagamento.getId());
		manager.remove(formaPagamento);
	}

}
