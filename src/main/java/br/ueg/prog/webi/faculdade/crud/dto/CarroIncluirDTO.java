package br.ueg.prog.webi.faculdade.crud.dto;

import jakarta.persistence.Column;
import lombok.Data;

public @Data class CarroIncluirDTO {
    private String placa;
    private String modelo;
    private Long quilometragem;
    private Integer ano;
    private String cor;
}
