package br.ueg.prog.webi.faculdade.crud.dto;

import lombok.Data;

import java.util.Date;

public @Data class AluguelDTO {
    private Long id;
    private Long cpf_cliente;
    private String carro_placa;
    private String data_inicio;
    private String data_fim;
    private Double valor;
}
