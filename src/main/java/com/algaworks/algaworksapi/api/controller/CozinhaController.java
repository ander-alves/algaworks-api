package com.algaworks.algaworksapi.api.controller;

import com.algaworks.algaworksapi.api.converter.CozinhaDtoConverter;
import com.algaworks.algaworksapi.api.converter.CozinhaInputConverter;
import com.algaworks.algaworksapi.api.model.CozinhaDTO;
import com.algaworks.algaworksapi.api.model.input.CozinhaIdInputDTO;
import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.model.Restaurante;
import com.algaworks.algaworksapi.domain.repository.CozinhaRepository;
import com.algaworks.algaworksapi.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@Autowired
	CozinhaDtoConverter cozinhaDtoConverter;

	@Autowired
	CozinhaInputConverter cozinhaInputConverter;

	@GetMapping
	public List<CozinhaDTO> listar() {
		return cozinhaDtoConverter.toCollectionDTO(cozinhaRepository.findAll());
	}
	
	@GetMapping("/{cozinhaId}")
	public CozinhaDTO buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);

		return cozinhaDtoConverter.toDTO(cozinha);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CozinhaDTO adicionar(@RequestBody @Valid CozinhaIdInputDTO cozinhaIdInputDTO) {
		Cozinha cozinha = cozinhaInputConverter.toDomainObject(cozinhaIdInputDTO);

		return cozinhaDtoConverter.toDTO(cadastroCozinha.salvar(cozinha));
	}

	@PutMapping("/{cozinhaId}")
	public Cozinha atualizar(@PathVariable Long cozinhaId,
							 @RequestBody @Valid Cozinha cozinha) {
		Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);
		BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
		return cadastroCozinha.salvar(cozinhaAtual);
	}


	@DeleteMapping("/{cozinhaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  remover(@PathVariable Long cozinhaId) {
		cadastroCozinha.excluir(cozinhaId);
	}

}
