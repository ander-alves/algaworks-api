package com.algaworks.algaworksapi.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UsuarioInputDTO {

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;
	
}
