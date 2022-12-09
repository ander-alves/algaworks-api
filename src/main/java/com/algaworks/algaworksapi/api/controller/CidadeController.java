package com.algaworks.algaworksapi.api.controller;

import com.algaworks.algaworksapi.api.converter.CidadeConverterToDTO;
import com.algaworks.algaworksapi.api.converter.CidadeInputDTOConverterToCidade;
import com.algaworks.algaworksapi.api.model.CidadeDTO;
import com.algaworks.algaworksapi.api.model.input.CidadeInputDTO;
import com.algaworks.algaworksapi.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algaworksapi.domain.exception.NegocioException;
import com.algaworks.algaworksapi.domain.model.Cidade;
import com.algaworks.algaworksapi.domain.repository.CidadeRepository;
import com.algaworks.algaworksapi.domain.service.CadastroCidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroCidadeService cadastroCidade;

	@Autowired
	private CidadeConverterToDTO cidadeConverterToDTO;
	@Autowired
	private CidadeInputDTOConverterToCidade cidadeInputDTOConverterToCidade;

	@GetMapping
	public List<CidadeDTO> listar() {
		return cidadeConverterToDTO.toCollectionDTO(cidadeRepository.findAll());
	}

	@GetMapping("/{cidadeId}")
	public CidadeDTO buscar(@PathVariable Long cidadeId) {
		final Cidade cidade = cadastroCidade.buscarOuFalhar(cidadeId);

		return cidadeConverterToDTO.toDTO(cidade);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CidadeDTO adicionar(@RequestBody @Valid CidadeInputDTO cidadeInputDTO) {
		try {

			Cidade cidade = cidadeInputDTOConverterToCidade.toDomainObject(cidadeInputDTO);

			return cidadeConverterToDTO.toDTO(cadastroCidade.salvar(cidade));
		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(),e);
		}
	}

	@PutMapping("/{cidadeId}")
	public CidadeDTO atualizar(@PathVariable Long cidadeId,
								 @RequestBody @Valid CidadeInputDTO cidadeInputDTO) {
		try {
			Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(cidadeId);

			cidadeInputDTOConverterToCidade.copyToDomainObject(cidadeInputDTO, cidadeAtual);

			cidadeAtual = cadastroCidade.salvar(cidadeAtual);

			return cidadeConverterToDTO.toDTO(cidadeAtual);
		} catch (EstadoNaoEncontradoException e) {
			throw new NegocioException(e.getMessage(), e);
		}
	}

	@DeleteMapping("/{cidadeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cidadeId) {
		cadastroCidade.excluir(cidadeId);
	}

}
