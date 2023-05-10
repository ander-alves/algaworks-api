package com.algaworks.algaworksapi.api.controller;

import com.algaworks.algaworksapi.api.converter.FormaPagamentoInputDTOConverterToFormaPagamento;
import com.algaworks.algaworksapi.api.converter.FormaPagamentoToDTO;
import com.algaworks.algaworksapi.api.model.FormaPagamentoDTO;
import com.algaworks.algaworksapi.domain.model.Restaurante;
import com.algaworks.algaworksapi.domain.service.CadastroRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/restaurantes/{restauranteId}/formas-pagamento")
public class RestaurantePagamentoController {


    @Autowired
    private CadastroRestauranteService cadastroRestaurante;

    @Autowired
    private FormaPagamentoToDTO formaPagamentoToDTO;

    @Autowired
    private FormaPagamentoInputDTOConverterToFormaPagamento formaPagamentoInputDTOConverterToFormaPagamento;

    @GetMapping
    public List<FormaPagamentoDTO> listar(@PathVariable Long restauranteId) {
        Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);

        return formaPagamentoToDTO.toCollectionModel(restaurante.getFormasPagamento());
    }

    @DeleteMapping("/{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desassociar (@PathVariable Long restauranteId,@PathVariable Long formaPagamentoId){
        cadastroRestaurante.desassociarFormaPagamento(restauranteId,formaPagamentoId);
    }

    @PutMapping("/{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associar (@PathVariable Long restauranteId,@PathVariable Long formaPagamentoId){
        cadastroRestaurante.associarFormaPagamento(restauranteId,formaPagamentoId);
    }
}

//    @GetMapping("/{restauranteId}")
//    public FormaPagamentoDTO buscar(@PathVariable Long restauranteId) {
//
//        Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);
//
//        return formaPagamentoToDTO.toCollectionModel(restauranteId);
//    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public RestauranteDTO adicionar(@RequestBody @Valid RestauranteInputDTO restauranteInputDTO) {
//        try {
//            Restaurante restaurante = restauranteInputDTOConverterToRestaurante.toDomainObject(restauranteInputDTO);
//
//            return restauranteConverterToDto.toDTO(cadastroRestaurante.salvar(restaurante));
//        } catch (CozinhaNaoEncontradaException e) {
//            throw new NegocioException(e.getMessage(), e);
//        }
//    }
//
//    @PutMapping("/{restauranteId}")
//    public RestauranteDTO atualizar(@PathVariable Long restauranteId,
//                                 @RequestBody @Valid RestauranteInputDTO restauranteInput) {
//
//
//        Restaurante restauranteAtual = cadastroRestaurante.buscarOuFalhar(restauranteId);
//
//        restauranteInputDTOConverterToRestaurante.copyToDomainObjetc(restauranteInput, restauranteAtual);
//
//        try {
//            return restauranteConverterToDto.toDTO(cadastroRestaurante.salvar(restauranteAtual));
//        } catch (EntidadeNaoEncontradaException e) {
//            throw new NegocioException(e.getMessage(), e);
//        }
//    }
//
//    @PutMapping("/{restauranteId}/ativo")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void ativar (@PathVariable Long restauranteId) {
//        cadastroRestaurante.ativar(restauranteId);
//    }
//    @DeleteMapping("/{restauranteId}/ativo")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void inativar (@PathVariable Long restauranteId) {
//        cadastroRestaurante.inativar(restauranteId);
//    }
//
//}
