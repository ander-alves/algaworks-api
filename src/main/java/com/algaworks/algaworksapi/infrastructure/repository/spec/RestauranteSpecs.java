package com.algaworks.algaworksapi.infrastructure.repository.spec;

import com.algaworks.algaworksapi.domain.model.Restaurante;
import org.springframework.data.jpa.domain.Specification;

public class RestauranteSpecs {
    public static Specification<Restaurante> comFreteGratis() {
        return new RestauranteComFreteGratisSpec();
    }
    public static Specification<Restaurante> comNomeSemelhante(String nome) {
        return new RestauranteComNomeSemelhanteSpec(nome);
    }
}
