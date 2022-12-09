package com.algaworks.algaworksapi.api.controller;

import java.util.List;
import java.util.Optional;

import com.algaworks.algaworksapi.api.converter.EstadoConverterToDTO;
import com.algaworks.algaworksapi.api.converter.EstadoInputDTOConverterToEstado;
import com.algaworks.algaworksapi.api.model.EstadoDTO;
import com.algaworks.algaworksapi.api.model.input.EstadoInputDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algaworksapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algaworksapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algaworksapi.domain.model.Estado;
import com.algaworks.algaworksapi.domain.repository.EstadoRepository;
import com.algaworks.algaworksapi.domain.service.CadastroEstadoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CadastroEstadoService cadastroEstado;

	@Autowired
	private EstadoConverterToDTO estadoConverterToDTO;

	@Autowired
	private EstadoInputDTOConverterToEstado estadoInputDTOConverterToEstado;
	
	@GetMapping
	public List<EstadoDTO> listar() {
		return estadoConverterToDTO.toCollectionDTO(estadoRepository.findAll());
	}
	
	@GetMapping("/{estadoId}")
	public EstadoDTO buscar(@PathVariable Long estadoId) {
		return estadoConverterToDTO.toDTO(cadastroEstado.buscarOuFalhar(estadoId));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoDTO adicionar(@RequestBody @Valid EstadoInputDTO estadoInputDTO) {
		Estado estado = estadoInputDTOConverterToEstado.toDomainObject(estadoInputDTO);

		return estadoConverterToDTO.toDTO(cadastroEstado.salvar(estado));
	}

	@PutMapping("/{estadoId}")
	public EstadoDTO atualizar(@PathVariable Long estadoId,
							@RequestBody @Valid EstadoInputDTO estadoInputDTO) {
		Estado estadoAtual = cadastroEstado.buscarOuFalhar(estadoId);

		estadoInputDTOConverterToEstado.copyToDomainObject(estadoInputDTO, estadoAtual);

		estadoAtual = cadastroEstado.salvar(estadoAtual);

		return estadoConverterToDTO.toDTO(estadoAtual);
	}


	@DeleteMapping("/{estadoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long estadoId) {
		cadastroEstado.excluir(estadoId);
	}
	
}
