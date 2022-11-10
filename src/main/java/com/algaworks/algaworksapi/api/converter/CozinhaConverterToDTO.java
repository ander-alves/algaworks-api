package com.algaworks.algaworksapi.api.converter;

import com.algaworks.algaworksapi.api.model.CozinhaDTO;
import com.algaworks.algaworksapi.api.model.input.CozinhaInputDTO;
import com.algaworks.algaworksapi.domain.model.Cozinha;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CozinhaConverterToDTO {

    @Autowired
    private  ModelMapper modelMapper;
    public CozinhaDTO toDTO(Cozinha cozinha) {
        return modelMapper.map(cozinha,CozinhaDTO.class);
    }

    public List<CozinhaDTO> toCollectionDTO(List<Cozinha> cozinhas) {

        return cozinhas.stream()
                .map(cozinha -> toDTO(cozinha))
                .collect(Collectors.toList());
    }
}
