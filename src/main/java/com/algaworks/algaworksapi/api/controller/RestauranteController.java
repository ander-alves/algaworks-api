package com.algaworks.algaworksapi.api.controller;

import com.algaworks.algaworksapi.api.converter.RestauranteConverterToDTO;
import com.algaworks.algaworksapi.api.converter.RestauranteInputDTOConverterToRestaurante;
import com.algaworks.algaworksapi.api.model.RestauranteDTO;
import com.algaworks.algaworksapi.api.model.input.RestauranteInputDTO;
import com.algaworks.algaworksapi.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algaworksapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algaworksapi.domain.exception.NegocioException;
import com.algaworks.algaworksapi.domain.model.Restaurante;
import com.algaworks.algaworksapi.domain.repository.RestauranteRepository;
import com.algaworks.algaworksapi.domain.service.CadastroRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @Autowired
    RestauranteConverterToDTO restauranteConverterToDto;

    @Autowired
    RestauranteInputDTOConverterToRestaurante restauranteInputDTOConverterToRestaurante;

    @GetMapping
    public List<RestauranteDTO> listar() {
        return restauranteConverterToDto.toCollectionDTO(restauranteRepository.findAll());
    }

    @GetMapping("/{restauranteId}")
    public RestauranteDTO buscar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);

        return restauranteConverterToDto.toDTO(restaurante);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestauranteDTO adicionar(@RequestBody @Valid RestauranteInputDTO restauranteInputDTO) {
        try {
            Restaurante restaurante = restauranteInputDTOConverterToRestaurante.toDomainObject(restauranteInputDTO);

            return restauranteConverterToDto.toDTO(cadastroRestaurante.salvar(restaurante));
        } catch (CozinhaNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @PutMapping("/{restauranteId}")
    public RestauranteDTO atualizar(@PathVariable Long restauranteId,
                                 @RequestBody @Valid RestauranteInputDTO restauranteInput) {


        Restaurante restauranteAtual = cadastroRestaurante.buscarOuFalhar(restauranteId);

        restauranteInputDTOConverterToRestaurante.copyToDomainObjetc(restauranteInput, restauranteAtual);

        try {
            return restauranteConverterToDto.toDTO(cadastroRestaurante.salvar(restauranteAtual));
        } catch (EntidadeNaoEncontradaException e) {
            throw new NegocioException(e.getMessage(), e);
        }
    }

}
