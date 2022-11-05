package com.algaworks.algaworksapi.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CozinhaIdInputDTO {

    @NotNull
    private Long id;
}
