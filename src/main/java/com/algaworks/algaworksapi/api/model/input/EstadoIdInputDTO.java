package com.algaworks.algaworksapi.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EstadoIdInputDTO {

	@NotNull
	private Long id;
	
}
