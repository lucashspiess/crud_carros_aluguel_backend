package br.ueg.prog.webi.faculdade.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TBL_CARRO")
public class Carro {
    @Id
    @Column(length = 8)
    private String placa;

    @Column(length = 30, nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Long quilometragem;

    @Column(nullable = false)
    private Integer ano;

    @Column(length = 30, nullable = false)
    private String cor;

    @Column(nullable = false)
    private Double diaria;

    @Column(length = 30)
    private String status;

}
