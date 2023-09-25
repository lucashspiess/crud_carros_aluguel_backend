package br.ueg.prog.webi.faculdade.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    public Long codigo;

    public String login;

    public String senha;

    public String nome;

    public String email;

    public boolean status;

    public String role;
}
