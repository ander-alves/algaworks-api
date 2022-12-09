package com.algaworks.algaworksapi.api.converter;

import com.algaworks.algaworksapi.api.model.input.CidadeInputDTO;
import com.algaworks.algaworksapi.domain.model.Cidade;
import com.algaworks.algaworksapi.domain.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CidadeInputDTOConverterToCidade {
    @Autowired
    private ModelMapper modelMapper;

    public Cidade toDomainObject(CidadeInputDTO cidadeInputDTO) {
        return modelMapper.map(cidadeInputDTO, Cidade.class);
    }
    public void copyToDomainObject(CidadeInputDTO cidadeInputDTO, Cidade cidade) {
        // Para evitar org.hibernate.HibernateException: identifier of an instance of
        // com.algaworks.algafood.domain.model.Estado was altered from 1 to 2

        cidade.setEstado(new Estado());

        modelMapper.map(cidadeInputDTO, cidade);
    }
}
