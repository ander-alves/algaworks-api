package com.algaworks.algaworksapi.api.controller;

import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.repository.CozinhaRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepositry cozinhaRepositry;

    @GetMapping
    public List<Cozinha> listar() {
        return cozinhaRepositry.listar();
    }
}
