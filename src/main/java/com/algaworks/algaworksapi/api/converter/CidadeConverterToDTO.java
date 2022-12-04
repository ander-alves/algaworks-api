package com.algaworks.algaworksapi.api.converter;

import com.algaworks.algaworksapi.api.model.CidadeDTO;
import com.algaworks.algaworksapi.domain.model.Cidade;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CidadeConverterToDTO {

    @Autowired
    private ModelMapper modelMapper;

    public CidadeDTO toDTO(Cidade cidade) {
        return modelMapper.map(cidade, CidadeDTO.class);
    }

    public List<CidadeDTO> toCollectionDTO(List<Cidade> cidades) {
        return cidades.stream()
                .map(cidade -> toDTO(cidade))
                .collect(Collectors.toList());
    }

}
