package com.algaworks.algaworksapi.api.exceptionHandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    ERRO_NEGOCIO("/entidade-em-uso","Entidade em Uso"),
    ENTIDADE_EM_USO("/entidade-em-uso","Entidade em Uso"),
    FORMATO_CORPO_INVALIDO("/formato-do-corpo-invalido","Formato de corpo enviado esta Errado"),
    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade nao encontrada"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    RECURSO_NAO_ENCONTRADO ("/recurso-nao-encontrado", "Recurso não encontrado");
    private String title;
    private String uri;

    ProblemType (String path, String title) {
        this.uri = "http>//algaworks.com.br" + path;
        this.title = title;
    }

}
