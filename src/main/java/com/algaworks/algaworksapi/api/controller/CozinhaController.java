package com.algaworks.algaworksapi.api.controller;

import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.repository.CozinhaRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cozinhas") //Boa pratica colocar no plural.
public class CozinhaController {

    @Autowired
    private CozinhaRepositry cozinhaRepositry;

    @GetMapping
    public List<Cozinha> listar() {
        return cozinhaRepositry.listar();
    }

    @GetMapping("/{cozinhaId}")
    public Cozinha buscar (@PathVariable("cozinhaId") Long id) {
        return cozinhaRepositry.buscar(id);
    }
}
