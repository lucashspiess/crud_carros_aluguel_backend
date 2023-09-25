package br.ueg.prog.webi.faculdade.crud.model;

import br.ueg.prog.webi.api.model.BaseEntidade;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Getter
@Table(name = "TBL_usuario")
public class Usuario extends BaseEntidade<Long> {

    public static final class Coluna {
        public static final String ID = "userid";
    }

    @SequenceGenerator(
            name = "a_gerador_sequence",
            sequenceName = "usuario_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "a_gerador_sequence"

    )

    @Id
    @Column(name = Coluna.ID)
    private Long codigo;

    @Column(name = "login", length = 200, nullable = false, unique = true)
    private String login;

    @Column(name = "senha", length = 200, nullable = false)
    private String senha;

    @Column(name = "nome", length = 200, nullable = false, unique = true)
    private String nome;

    @Column(name = "email", length = 200, nullable = false)
    private String email;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "role", length = 200, nullable = true)
    private String role;

    @Override
    public String getTabelaNome() {
        return "TBL_usuario";
    }

    @Override
    public Long getId() {
        return codigo;
    }

    @Override
    public void setId(Long id) {
        this.codigo = id;
    }
}
