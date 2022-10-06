package com.algaworks.algaworksapi.api.controller;

import com.algaworks.algaworksapi.domain.model.Cidade;
import com.algaworks.algaworksapi.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidades") //Boa pratica colocar no plural.
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public List<Cidade> listar() {
        return cidadeRepository.findAll();
    }
}
