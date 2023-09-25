package br.ueg.prog.webi.faculdade.crud.service.impl;

import br.ueg.prog.webi.api.dto.CredencialDTO;
import br.ueg.prog.webi.api.dto.UsuarioSenhaDTO;
import br.ueg.prog.webi.faculdade.crud.controller.UsuarioController;
import br.ueg.prog.webi.faculdade.crud.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

@Service
public class UserProviderService implements br.ueg.prog.webi.api.service.UserProviderService {

    @Autowired
    UsuarioController usuarioController;

    @Override
    public CredencialDTO getCredentialByLogin(String username) {

        if (Objects.nonNull(username)) {

            UsuarioDTO user = this.usuarioController.obterPorLogin(username);

            if (Objects.nonNull(user)) {

                return getCredencialDTO(user);

            }

        }
        return null;
    }

    private CredencialDTO getCredencialDTO(UsuarioDTO user) {

        return CredencialDTO.builder()
                .login(user.getLogin())
                .id(user.getCodigo())
                .nome(user.getNome())
                .email(user.getEmail())
                .roles(Arrays.asList(user.getRole()))
                .statusAtivo(true)
                .senha(user.getSenha())
                .build();
    }

    @Override
    public CredencialDTO redefinirSenha(UsuarioSenhaDTO usuarioSenhaDTO) {
        return null;
    }

    @Override
    public CredencialDTO getCredentialByEmail(String email) {
        if (Objects.nonNull(email) && email.equals("admin@admin.com.br")) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String senhaCodificada = bCryptPasswordEncoder.encode("admin");
            return CredencialDTO.builder()
                    .login("admin")
                    .id(1L)
                    .nome("Admin")
                    .email("admin@admin.com.br")
                    .roles(Arrays.asList("ROLE_ADMIN", "ROLE_TIPO_INCLUIR"))
                    .statusAtivo(true)
                    .senha(senhaCodificada)
                    .build();
        }
        return null;
    }
}
