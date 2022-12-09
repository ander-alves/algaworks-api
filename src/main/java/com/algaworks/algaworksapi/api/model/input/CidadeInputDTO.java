package com.algaworks.algaworksapi.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CidadeInputDTO {
    @NotBlank
    private String nome;

    @Valid
    @NotNull
    private EstadoIdInputDTO estado;
}
