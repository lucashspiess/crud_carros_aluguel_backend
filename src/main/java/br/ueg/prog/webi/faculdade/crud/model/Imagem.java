package br.ueg.prog.webi.faculdade.crud.model;

import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TBL_imagem")
public class Imagem extends BaseEntidade<Long> {

    @SequenceGenerator(
            name = "a_gerador_sequence",
            sequenceName = "imagem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "a_gerador_sequence"
    )

    @Id
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "img_blob")
    private byte[] img;
}
