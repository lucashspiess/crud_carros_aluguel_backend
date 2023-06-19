package br.ueg.prog.webi.faculdade.crud.model;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "TBL_CLIENTE")
public class Cliente {
    @SequenceGenerator(
            name="a_gerador_sequence",
            sequenceName = "cliente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "a_gerador_sequence"
    )
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", length = 30, nullable = false)
    private String nome;

    @Column(name = "cpf",length = 11, nullable = false)
    private Long cpf;

    @Column(name="email",nullable = false)
    private String email;
}
