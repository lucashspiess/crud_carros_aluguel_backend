package br.ueg.prog.webi.faculdade.crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_CARRO")
public class Carro {
    @Id
    @Column(length = 8)
    private String placa;

    @Column(length = 30, nullable = false)
    private String modelo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_id", nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_carro_tipo"))
    private Tipo tipo;

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
