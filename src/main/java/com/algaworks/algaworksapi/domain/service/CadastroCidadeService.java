package com.algaworks.algaworksapi.domain.service;

import com.algaworks.algaworksapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algaworksapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algaworksapi.domain.model.Cidade;
import com.algaworks.algaworksapi.domain.model.Cozinha;
import com.algaworks.algaworksapi.domain.model.Estado;
import com.algaworks.algaworksapi.domain.model.Restaurante;
import com.algaworks.algaworksapi.domain.repository.CidadeRepository;
import com.algaworks.algaworksapi.domain.repository.CozinhaRepository;
import com.algaworks.algaworksapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;
    private EstadoRepository estadoRepository;

        public Cidade salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();

        Estado estado = estadoRepository.findById(estadoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Não existe cadastro de cozinha com código %d", estadoId)));

        cidade.setEstado(estado);

        return cidadeRepository.save(cidade);
    }

    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.deleteById(cidadeId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format(
                    "Nao Existe um cadastro de Cidade referente ao codigo %d", cidadeId
            ));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(
                    "Cidade de Codigo %d nao pode ser removida, pois esta em uso", cidadeId
            ));
        }
    }
}