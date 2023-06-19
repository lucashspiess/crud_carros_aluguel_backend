package br.ueg.prog.webi.faculdade.crud.service.impl;

import br.ueg.prog.webi.faculdade.crud.model.Aluguel;
import br.ueg.prog.webi.faculdade.crud.model.Cliente;
import br.ueg.prog.webi.faculdade.crud.repository.AluguelRepository;
import br.ueg.prog.webi.faculdade.crud.service.AluguelService;
import br.ueg.prog.webi.faculdade.crud.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.joda.time.*;
import java.util.List;
@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private CarroService carroService;

    @Autowired
    private AluguelRepository aluguelRepository;

    @Override
    public Aluguel incluir(String placa, Aluguel aluguel) {
        aluguel.setPlaca(placa);
        aluguel.setValor(this.calcularValorTotal(aluguel, placa));
        carroService.alugar(placa);
        return this.gravarDados(aluguel);
    }

    private Aluguel gravarDados(Aluguel aluguel) {
        return aluguelRepository.save(aluguel);
    }

    @Override
    public Aluguel alterar(Aluguel aluguel, Long id) {
        Aluguel aluguelBD = recuperarAluguelOuGeraErro(id);
        aluguel.setId(id);
        return this.gravarDados(aluguel);
    }

    private Aluguel recuperarAluguelOuGeraErro(Long id) {
        return aluguelRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Erro ao localizarr aluguel"
                        )
                );
    }

    @Override
    public Aluguel excluir(Long id) {
        Aluguel aluguelExcluir = this.recuperarAluguelOuGeraErro(id);
        this.aluguelRepository.delete(aluguelExcluir);
        this.carroService.desalugar(aluguelExcluir.getPlaca());
        return aluguelExcluir;
    }

    @Override
    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }

    @Override
    public Double calcularValorTotal(Aluguel aluguel, String placa) {
        LocalDate data_inicio = new LocalDate(aluguel.getData_inicio());
        LocalDate data_fim = new LocalDate(aluguel.getData_fim());
        Period periodo = new Period(data_inicio,data_fim);
        return carroService.obterCarroPelaPlaca(placa).getDiaria()*periodo.getDays();
    }

    @Override
    public Aluguel obterPelaPlaca(String placa) {
        return  aluguelRepository
                .findByPlaca(placa)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Erro ao localizarr aluguel"
                        )
                );
    }
}

