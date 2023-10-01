package br.ueg.prog.webi.faculdade.crud.repository;

import br.ueg.prog.webi.faculdade.crud.model.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem,Long> {
    Optional<Imagem> findByCaminhoArq(String caminho);
}
