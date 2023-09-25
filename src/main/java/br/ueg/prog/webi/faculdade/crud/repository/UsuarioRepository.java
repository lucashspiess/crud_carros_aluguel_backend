package br.ueg.prog.webi.faculdade.crud.repository;

import br.ueg.prog.webi.faculdade.crud.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT user FROM Usuario user where user.login = :login")
    Usuario obterPeloLogin(@Param("login") String login);

    @Query("SELECT user FROM Usuario user where user.nome= :username")
    Usuario obterPeloUsername(@Param("username") String username);
}
