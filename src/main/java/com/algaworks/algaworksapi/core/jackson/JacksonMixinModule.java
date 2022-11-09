package com.algaworks.algaworksapi.core.jackson;

import com.algaworks.algaworksapi.api.model.mixin.CidadeMixin;
import com.algaworks.algaworksapi.api.model.mixin.CozinhaMixin;
import com.algaworks.algaworksapi.domain.model.Cidade;
import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	public JacksonMixinModule() {
		setMixInAnnotation(Cidade.class, CidadeMixin.class);
		setMixInAnnotation(Cozinha.class, CozinhaMixin.class);

	}
	
}
