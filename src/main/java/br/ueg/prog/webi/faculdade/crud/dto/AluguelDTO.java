package br.ueg.prog.webi.faculdade.crud.dto;

import lombok.Data;

import java.util.Date;

public @Data class AluguelDTO {
    private Long id;
    private Long cpf_cliente;
    private String placa;
    private Date data_inicio;
    private Date data_fim;
    private Double valor;
}
