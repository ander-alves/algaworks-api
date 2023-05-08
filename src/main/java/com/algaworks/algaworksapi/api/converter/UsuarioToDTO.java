package com.algaworks.algaworksapi.api.converter;

import com.algaworks.algaworksapi.api.model.UsuarioDTO;
import com.algaworks.algaworksapi.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioToDTO {

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioDTO toDto(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public List<UsuarioDTO> toCollectionModel(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(usuario -> toDto(usuario))
                .collect(Collectors.toList());
    }


}
