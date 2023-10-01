package br.ueg.prog.webi.faculdade.crud.model;

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
public class Carro implements IEntidade {
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "imagem_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_carro_imagem"))
    private Imagem imagem;

    @Column(nullable = false)
    private Double diaria;

    @Column(nullable = false)
    private String marca;

    @Column(length = 30)
    private String status;

    @Override
    public String getTabelaNome() {
        return null;
    }

    @Override
    public Object getId() {
        return this.placa;
    }

    @Override
    public boolean isNew() {
        return false;
    }

    @Override
    public String getIdHash() {
        return null;
    }

    @Override
    public Object getIdFromHash(String hash) {
        return null;
    }

    @Override
    public void setId(Object id) {
        this.placa = id.toString();
    }

    @Override
    public void setNew() {

    }

    @Override
    public Map<String, IEntidade<?>> getForeignEntitiesMaps() {
        return null;
    }

    @Override
    public void setForeignEntitiesMaps(Map foreignEntities) {

    }
}
