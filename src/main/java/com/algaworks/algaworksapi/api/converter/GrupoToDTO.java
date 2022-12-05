package com.algaworks.algaworksapi.api.converter;

import com.algaworks.algaworksapi.api.model.GrupoDTO;
import com.algaworks.algaworksapi.domain.model.Grupo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GrupoToDTO {

	@Autowired
	private ModelMapper modelMapper;
	
	public GrupoDTO toDTO(Grupo grupo) {
		return modelMapper.map(grupo, GrupoDTO.class);
	}
	
	public List<GrupoDTO> toCollectionModel(List<Grupo> grupos) {
		return grupos.stream()
				.map(grupo -> toDTO(grupo))
				.collect(Collectors.toList());
	}
	
}
