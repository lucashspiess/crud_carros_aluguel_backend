package br.ueg.prog.webi.faculdade.crud.model;

import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBL_tipo")
public class Tipo extends BaseEntidade<Long> {

    @Id
    @SequenceGenerator(
            name = "a_gerador_sequence",
            sequenceName = "tipo_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "a_gerador_sequence"

    )
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;
}
