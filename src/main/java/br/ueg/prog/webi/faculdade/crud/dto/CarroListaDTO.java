package br.ueg.prog.webi.faculdade.crud.dto;

import lombok.Data;

public @Data class CarroListaDTO {
    private String placa;
    private String modelo;
    private Long quilometragem;
    private Integer ano;
    private String cor;
    private String status;
}
