package com.algaworks.algaworksapi.api.converter;

import com.algaworks.algaworksapi.api.model.input.CidadeInputDTO;
import com.algaworks.algaworksapi.api.model.input.EstadoInputDTO;
import com.algaworks.algaworksapi.domain.model.Cidade;
import com.algaworks.algaworksapi.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EstadoInputDTOConverterToEstado {
    @Autowired
    private ModelMapper modelMapper;

    public Estado toDomainObject(EstadoInputDTO estadoInputDTO) {
        return modelMapper.map(estadoInputDTO, Estado.class);
    }
    public void copyToDomainObject(EstadoInputDTO estadoInputDTO, Estado estado) {
        modelMapper.map(estadoInputDTO, estado);
    }
}
