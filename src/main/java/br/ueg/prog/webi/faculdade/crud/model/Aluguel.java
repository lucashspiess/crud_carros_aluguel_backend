package br.ueg.prog.webi.faculdade.crud.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "TBL_ALUGUEL")
public class Aluguel {
    @SequenceGenerator(
            name="b_gerador_sequence",
            sequenceName = "aluguel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "b_gerador_sequence"
    )
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_aluguel_cliente"))
    private Cliente cliente;

    @Column(name = "placa",length = 8, nullable = false)
    private String placa;

    @Column(name="data_inicio",nullable = false)
    private Date data_inicio;

    @Column(name="data_fim",nullable = false)
    private Date data_fim;

    @Column(name="valor", nullable = false)
    private Double valor;
}
