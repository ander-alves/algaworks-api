package com.algaworks.algaworksapi.api.controller;

import com.algaworks.algaworksapi.api.converter.CozinhaConverterToDTO;
import com.algaworks.algaworksapi.api.converter.CozinhaInputDTOConverterToCozinha;
import com.algaworks.algaworksapi.api.model.CozinhaDTO;
import com.algaworks.algaworksapi.api.model.input.CozinhaIdInputDTO;
import com.algaworks.algaworksapi.api.model.input.CozinhaInputDTO;
import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.repository.CozinhaRepository;
import com.algaworks.algaworksapi.domain.service.CadastroCozinhaService;
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
	CozinhaConverterToDTO cozinhaConverterToDTO;

	@Autowired
	CozinhaInputDTOConverterToCozinha cozinhaInputDTOConverterToCozinha;

	@GetMapping
	public List<CozinhaDTO> listar() {
		return cozinhaConverterToDTO.toCollectionDTO(cozinhaRepository.findAll());
	}
	
	@GetMapping("/{cozinhaId}")
	public CozinhaDTO buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cadastroCozinha.buscarOuFalhar(cozinhaId);

		return cozinhaConverterToDTO.toDTO(cozinha);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CozinhaDTO adicionar(@RequestBody @Valid CozinhaIdInputDTO cozinhaIdInputDTO) {
		Cozinha cozinha = cozinhaInputDTOConverterToCozinha.toDomainObject(cozinhaIdInputDTO);

		return cozinhaConverterToDTO.toDTO(cadastroCozinha.salvar(cozinha));
	}

	@PutMapping("/{cozinhaId}")
	public CozinhaDTO atualizar(@PathVariable Long cozinhaId,
								  @RequestBody @Valid CozinhaInputDTO cozinhaInput) {
		Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);
		cozinhaInputDTOConverterToCozinha.copyToDomainObject(cozinhaInput, cozinhaAtual);
		cozinhaAtual = cadastroCozinha.salvar(cozinhaAtual);

		return cozinhaConverterToDTO.toDTO(cozinhaAtual);
	}


	@DeleteMapping("/{cozinhaId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  remover(@PathVariable Long cozinhaId) {
		cadastroCozinha.excluir(cozinhaId);
	}

}
