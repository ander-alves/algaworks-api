package com.algaworks.algaworksapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cozinha {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore //nao mostra a propriedade no json solicitado pelo consumidor da api//
    private Long id;

    @JsonProperty("titulo") //muda a representação para os consumidores da api, NAO MUDA A PROPRIEDADE.//
    @Column(nullable = false)
    private String nome;

}
