package com.algaworks.algaworksapi.jpa;

import com.algaworks.algaworksapi.domain.model.Cozinha;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager maneger;

    public List<Cozinha> listar() {
       TypedQuery<Cozinha> query = maneger.createQuery("from Cozinha",Cozinha.class);

       return  query.getResultList();
    }

    @Transactional
    public Cozinha adicionar (Cozinha cozinha) {
        return maneger.merge(cozinha);

    }
}
