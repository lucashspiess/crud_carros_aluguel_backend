package br.ueg.prog.webi.faculdade.crud.repository;

import br.ueg.prog.webi.faculdade.crud.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long>{
    Optional<Cliente>findById(Long id);
    Optional<Cliente>findByCpf(Long cpf);
}
