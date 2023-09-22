package br.ueg.prog.webi.faculdade.crud.service.impl;

import br.ueg.prog.webi.api.dto.CredencialDTO;
import br.ueg.prog.webi.api.dto.UsuarioSenhaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//TODO resolver a parte do usuario aqui dentro
@Service
public class UserProviderService implements br.ueg.prog.webi.api.service.UserProviderService {
    @Override
    public CredencialDTO getCredentialByLogin(String usuarioEmail) {

        return null;
    }


    private CredencialDTO getCredencialDTO(String user) {

        System.out.println(user.toString());

        return null;
    }


    @Override
    public CredencialDTO redefinirSenha(UsuarioSenhaDTO usuarioSenhaDTO) {
        return null;
    }

    @Override
    public CredencialDTO getCredentialByEmail(String email) {
        return null;
    }
}