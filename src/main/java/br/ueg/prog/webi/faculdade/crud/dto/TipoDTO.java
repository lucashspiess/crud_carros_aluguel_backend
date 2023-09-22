package br.ueg.prog.webi.faculdade.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDTO {

    private Long id;

    private String nome;

    private String descricao;
}
