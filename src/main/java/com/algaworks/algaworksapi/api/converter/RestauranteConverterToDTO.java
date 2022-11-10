package com.algaworks.algaworksapi.api.converter;

import com.algaworks.algaworksapi.api.model.RestauranteDTO;
import com.algaworks.algaworksapi.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestauranteConverterToDTO {

    @Autowired
    private  ModelMapper modelMapper;
    public RestauranteDTO toDTO(Restaurante restaurante) {
        return modelMapper.map(restaurante,RestauranteDTO.class);
    }

    public List<RestauranteDTO> toCollectionDTO(List<Restaurante> restaurantes) {

        return restaurantes.stream()
                .map(restaurante -> toDTO(restaurante))
                .collect(Collectors.toList());
    }

}
