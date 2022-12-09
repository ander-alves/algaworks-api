package com.algaworks.algaworksapi.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CidadeIdInputDTO {

	@NotNull
	private Long id;
	
}
