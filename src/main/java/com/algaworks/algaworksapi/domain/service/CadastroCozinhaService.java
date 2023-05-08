package com.algaworks.algaworksapi.domain.service;

import com.algaworks.algaworksapi.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algaworksapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

	public static final String MSG_COZINHA_NAO_ENCONTRADA
			="Não existe um cadastro de cozinha com código %d";

	public static final String MSG_COZINHA_ID_EM_USO
			="Cozinha de código %d não pode ser removida, pois está em uso";

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha)	 {
		return cozinhaRepository.save(cozinha);
	}
	
	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.deleteById(cozinhaId);
			cozinhaRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new CozinhaNaoEncontradaException(cozinhaId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_COZINHA_ID_EM_USO, cozinhaId));
		}
	}

	public Cozinha buscarOuFalhar (Long cozinhaId) {
		return cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() ->new CozinhaNaoEncontradaException(cozinhaId));
	}

	public Cozinha buscarPorNome(String nome) {
		return cozinhaRepository.findByNome(nome)
				.orElseThrow(() -> new CozinhaNaoEncontradaException(nome));
	}
}
