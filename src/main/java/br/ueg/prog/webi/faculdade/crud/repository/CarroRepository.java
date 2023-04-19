package br.ueg.prog.webi.faculdade.crud.repository;

import br.ueg.prog.webi.faculdade.crud.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarroRepository extends JpaRepository <Carro, String> {
    Optional<Carro> findByModelo(String modelo);
    Optional<Carro> findByPlaca(String placa);
}
