package com.algaworks.algaworksapi.api.model.mixin;

import com.algaworks.algaworksapi.domain.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CozinhaMixin {

	@JsonIgnore
	private List<Restaurante> restaurantes = new ArrayList<>();
	
}
