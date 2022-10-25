package com.algaworks.algaworksapi;

import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.service.CadastroCozinhaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CadastroCozinhaIntegrationTests {

	private CadastroCozinhaService cadastroCozinha;

	@Test
	public void contextLoads() {
	}

	public void testarCadastroCozinhaComSucesso() {
		//cenario
		Cozinha novaCozinha	= new Cozinha();
		novaCozinha.setNome("Chinesa");
		//acao
		novaCozinha = cadastroCozinha.salvar(novaCozinha);
		//validacao
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}

}
