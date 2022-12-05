package com.algaworks.algaworksapi.api.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algaworksapi.api.model.input.GrupoInputDTO;
import com.algaworks.algaworksapi.domain.model.Grupo;

@Component
public class GrupoInputDTOToGrupo {

	@Autowired
	private ModelMapper modelMapper;
	
	public Grupo toDomainObject(GrupoInputDTO grupoInput) {
		return modelMapper.map(grupoInput, Grupo.class);
	}
	
	public void copyToDomainObject(GrupoInputDTO grupoInput, Grupo grupo) {
		modelMapper.map(grupoInput, grupo);
	}
	
}
