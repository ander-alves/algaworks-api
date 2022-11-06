package com.algaworks.algaworksapi;

import com.algaworks.algaworksapi.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algaworksapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.service.CadastroCozinhaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CadastroCozinhaIntegrationIT {
	public void deveRetornar200GetCozinhas(){

	}

// TESTES DE INTEGRACAO JUnit
//	@Autowired
//	private CadastroCozinhaService cadastroCozinha;
//
//	@Test
//	public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {
//		Cozinha novaCozinha = new Cozinha();
//		novaCozinha.setNome("Chinesa");
//
//		novaCozinha = cadastroCozinha.salvar(novaCozinha);
//
//		assertThat(novaCozinha).isNotNull();
//		assertThat(novaCozinha.getId()).isNotNull();
//	}
//	@Test(expected = ConstraintViolationException.class)
//	public void deveFalhar_QuandoCadastrarCozinhaSemNome() {
//		Cozinha novaCozinha = new Cozinha();
//		novaCozinha.setNome(null);
//
//		novaCozinha = cadastroCozinha.salvar(novaCozinha);
//	}
//
//	@Test(expected = EntidadeEmUsoException.class)
//	public void flharQndoExcluirCozinha (){
//		cadastroCozinha.excluir(1L);
//	}
//	@Test(expected = CozinhaNaoEncontradaException.class)
//	public void flharQndoExcluirCozinhaInexistente (){
//		cadastroCozinha.excluir(100L);
//	}

}
