package br.ueg.prog.webi.faculdade.crud.dto;

import lombok.Data;

public @Data class ClienteDTO {
    private Long id;
    private String nome;
    private Long cpf;
    private String email;
}
