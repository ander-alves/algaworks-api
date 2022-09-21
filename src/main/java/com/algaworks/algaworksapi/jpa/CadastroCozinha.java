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
    public Cozinha buscar(Long id) {
        return maneger.find(Cozinha.class,id);
    }

    @Transactional
    public Cozinha salvar(Cozinha cozinha) {
        return maneger.merge(cozinha);
    }

    @Transactional
    public void remover(Cozinha cozinha) {
        cozinha = buscar(cozinha.getId());
        maneger.remove(cozinha);
    }
}
