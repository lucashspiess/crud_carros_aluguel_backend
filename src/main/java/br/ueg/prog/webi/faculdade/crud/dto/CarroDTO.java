package br.ueg.prog.webi.faculdade.crud.dto;

import lombok.Data;

public @Data class CarroDTO {
    private String placa;
    private String modelo;
    private String marca;
    private String tipo_nome;
    private Long tipo_id;
    private Long quilometragem;
    private Integer ano;
    private String cor;
    private String status;
    private Double diaria;
}
