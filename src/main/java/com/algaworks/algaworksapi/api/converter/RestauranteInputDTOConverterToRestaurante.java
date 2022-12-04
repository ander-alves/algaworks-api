package com.algaworks.algaworksapi.api.converter;

import com.algaworks.algaworksapi.api.model.input.RestauranteInputDTO;
import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestauranteInputDTOConverterToRestaurante {

    @Autowired
    private ModelMapper modelMapper;

    public Restaurante toDomainObject(RestauranteInputDTO restauranteInputDTO) {
        return modelMapper.map(restauranteInputDTO, Restaurante.class);

    }
    public void copyToDomainObjetc(RestauranteInputDTO restauranteInputDTO,Restaurante restaurante) {
        restaurante.setCozinha(new Cozinha());
        modelMapper.map(restauranteInputDTO,restaurante);
    }
}
