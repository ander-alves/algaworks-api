package com.algaworks.algaworksapi.api.controller.exceptionHandler;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Problema {
    private LocalDateTime dateTime;
    private String mensagem;
}
