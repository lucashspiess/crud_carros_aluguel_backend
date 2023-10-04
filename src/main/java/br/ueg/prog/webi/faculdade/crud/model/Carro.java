package br.ueg.prog.webi.faculdade.crud.model;

import br.ueg.prog.webi.api.model.BaseEntidade;
import br.ueg.prog.webi.api.model.IEntidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_CARRO")
public class Carro extends BaseEntidade<String> {
    @Id
    @Column(length = 8)
    private String placa;

    @Column(length = 30, nullable = false)
    private String modelo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_carro_tipo"))
    private Tipo tipo;

    @Column(nullable = false)
    private Long quilometragem;

    @Column(nullable = false)
    private Integer ano;

    @Column(length = 30, nullable = false)
    private String cor;


    @Column(name = "imagem_id", nullable = false)
    private long imagem_id;

    @Column(nullable = false)
    private Double diaria;

    @Column(nullable = false)
    private String marca;

    @Column(length = 30)
    private String status;

}
