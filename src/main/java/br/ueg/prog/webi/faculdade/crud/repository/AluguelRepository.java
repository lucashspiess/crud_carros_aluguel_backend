package br.ueg.prog.webi.faculdade.crud.repository;

import br.ueg.prog.webi.faculdade.crud.model.Aluguel;
import br.ueg.prog.webi.faculdade.crud.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AluguelRepository extends JpaRepository <Aluguel, Long>{
    Optional<Aluguel>findById(Long id);
    Optional<Aluguel>findByPlaca(String placa);
}
