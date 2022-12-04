package com.algaworks.algaworksapi.core.modelMapper;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class modelMapperConfig {

    @Bean
    public ModelMapper modelMapper (){
        var modelMapper = new ModelMapper();
//        modelMapper.createTypeMap(Restaurante.class, RestauranteDTO.class)
//                .addMapping(Restaurante::getTaxaFrete,RestauranteDTO::setPrecoFrete);

//        var enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(
//                Endereco.class, EnderecoDTO.class);
//
//        enderecoToEnderecoModelTypeMap.<String>addMapping(
//                src -> src.getCidade().getEstado().getNome(),
//                (dest, value) -> dest.getCidade().setEstado(value));
//
// TODO Verificar motico de estar Dando Conflito.


        return modelMapper;
    }
}
