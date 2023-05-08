package com.algaworks.algaworksapi.api.converter;

import com.algaworks.algaworksapi.api.model.input.UsuarioInputDTO;
import com.algaworks.algaworksapi.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioInputDTOToUsuario {

	@Autowired
	private ModelMapper modelMapper;

	public Usuario toDto(UsuarioInputDTO usuarioInput) {
		return modelMapper.map(usuarioInput, Usuario.class);
	}

	public void copyToDomainObject(UsuarioInputDTO usuarioInput, Usuario usuario) {
		modelMapper.map(usuarioInput, usuario);
	}

}
