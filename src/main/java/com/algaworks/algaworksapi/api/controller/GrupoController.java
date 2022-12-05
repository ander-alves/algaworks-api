package com.algaworks.algaworksapi.api.controller;

import com.algaworks.algaworksapi.api.converter.GrupoInputDTOToGrupo;
import com.algaworks.algaworksapi.api.converter.GrupoToDTO;
import com.algaworks.algaworksapi.api.model.GrupoDTO;
import com.algaworks.algaworksapi.api.model.input.GrupoInputDTO;
import com.algaworks.algaworksapi.domain.model.Grupo;
import com.algaworks.algaworksapi.domain.repository.GrupoRepository;
import com.algaworks.algaworksapi.domain.service.CadastroGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/grupos")
public class GrupoController {

	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private CadastroGrupoService cadastroGrupo;
	
	@Autowired
	private GrupoToDTO grupoToDTO;
	
	@Autowired
	private GrupoInputDTOToGrupo grupoInputDTOToGrupo;
	
	@GetMapping
	public List<GrupoDTO> listar() {
		List<Grupo> todosGroups = grupoRepository.findAll();
		
		return grupoToDTO.toCollectionModel(todosGroups);
	}
	
	@GetMapping("/{grupoId}")
	public GrupoDTO buscar(@PathVariable Long grupoId) {
		Grupo grupo = cadastroGrupo.buscarOuFalhar(grupoId);
		
		return grupoToDTO.toDTO(grupo);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public GrupoDTO adicionar(@RequestBody @Valid GrupoInputDTO grupoInputDTO) {
		Grupo grupo = grupoInputDTOToGrupo.toDomainObject(grupoInputDTO);
		
		grupo = cadastroGrupo.salvar(grupo);
		
		return grupoToDTO.toDTO(grupo);
	}
	
	@PutMapping("/{grupoId}")
	public GrupoDTO atualizar(@PathVariable Long grupoId,
							  @RequestBody @Valid GrupoInputDTO grupoInputDTO) {
		Grupo grupoAtual = cadastroGrupo.buscarOuFalhar(grupoId);
		
		grupoInputDTOToGrupo.copyToDomainObject(grupoInputDTO, grupoAtual);
		
		grupoAtual = cadastroGrupo.salvar(grupoAtual);
		
		return grupoToDTO.toDTO(grupoAtual);
	}
	
	@DeleteMapping("/{grupoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long grupoId) {
		cadastroGrupo.excluir(grupoId);	
	}
	
}
