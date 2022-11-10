package com.algaworks.algaworksapi.api.converter;

import com.algaworks.algaworksapi.api.model.input.CozinhaIdInputDTO;
import com.algaworks.algaworksapi.api.model.input.RestauranteInputDTO;
import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CozinhaInputConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Cozinha toDomainObject(CozinhaIdInputDTO cozinhaIdInputDTO) {
        return modelMapper.map(cozinhaIdInputDTO, Cozinha.class);

    }
    public void copyToDomainObjetc(CozinhaIdInputDTO cozinhaIdInputDTO,Cozinha cozinha) {
        cozinha.setRestaurantes((List<Restaurante>) new Restaurante()); //TODO revisar este item.
        modelMapper.map(cozinhaIdInputDTO,cozinha);
    }
}
