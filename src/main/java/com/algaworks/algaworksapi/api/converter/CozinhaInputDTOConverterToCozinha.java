package com.algaworks.algaworksapi.api.converter;

import com.algaworks.algaworksapi.api.model.input.CozinhaInputDTO;
import com.algaworks.algaworksapi.domain.model.Cozinha;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class CozinhaInputDTOConverterToCozinha {

    @Autowired
    private ModelMapper modelMapper;

    public Cozinha toDomainObject( CozinhaInputDTO cozinhaIdInputDTO) {
        return modelMapper.map(cozinhaIdInputDTO, Cozinha.class);

    }
    public void copyToDomainObject(CozinhaInputDTO cozinhaInputDTO, Cozinha cozinha) {
        modelMapper.map(cozinhaInputDTO, cozinha);
    }
}
