package com.algaworks.algaworksapi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algaworksapi.api.converter.FormaPagamentoInputDTOConverterToFormaPagamento;
import com.algaworks.algaworksapi.api.converter.FormaPagamentoToDTO;
import com.algaworks.algaworksapi.api.model.FormaPagamentoDTO;
import com.algaworks.algaworksapi.api.model.input.FormaPagamentoInput;
import com.algaworks.algaworksapi.domain.model.FormaPagamento;
import com.algaworks.algaworksapi.domain.repository.FormaPagamentoRepository;
import com.algaworks.algaworksapi.domain.service.CadastroFormaPagamentoService;

@RestController
@RequestMapping("/formas-pagamento")
public class FormaPagamentoController {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private CadastroFormaPagamentoService cadastroFormaPagamento;
	
	@Autowired
	private FormaPagamentoToDTO formaPagamentoToDTO;
	
	@Autowired
	private FormaPagamentoInputDTOConverterToFormaPagamento formaPagamentoInputDTOConverterToFormaPagamento;
	
	@GetMapping
	public List<FormaPagamentoDTO> listar() {
		List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.findAll();
		
		return formaPagamentoToDTO.toCollectionModel(todasFormasPagamentos);
	}
	
	@GetMapping("/{formaPagamentoId}")
	public FormaPagamentoDTO buscar(@PathVariable Long formaPagamentoId) {
		FormaPagamento formaPagamento = cadastroFormaPagamento.buscarOuFalhar(formaPagamentoId);
		
		return formaPagamentoToDTO.toModel(formaPagamento);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FormaPagamentoDTO adicionar(@RequestBody @Valid FormaPagamentoInput formaPagamentoInput) {
		FormaPagamento formaPagamento = formaPagamentoInputDTOConverterToFormaPagamento.toDomainObject(formaPagamentoInput);
		
		formaPagamento = cadastroFormaPagamento.salvar(formaPagamento);
		
		return formaPagamentoToDTO.toModel(formaPagamento);
	}
	
	@PutMapping("/{formaPagamentoId}")
	public FormaPagamentoDTO atualizar(@PathVariable Long formaPagamentoId,
			@RequestBody @Valid FormaPagamentoInput formaPagamentoInput) {
		FormaPagamento formaPagamentoAtual = cadastroFormaPagamento.buscarOuFalhar(formaPagamentoId);
		
		formaPagamentoInputDTOConverterToFormaPagamento.copyToDomainObject(formaPagamentoInput, formaPagamentoAtual);
		
		formaPagamentoAtual = cadastroFormaPagamento.salvar(formaPagamentoAtual);
		
		return formaPagamentoToDTO.toModel(formaPagamentoAtual);
	}
	
	@DeleteMapping("/{formaPagamentoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long formaPagamentoId) {
		cadastroFormaPagamento.excluir(formaPagamentoId);	
	}
	
}
