package br.ueg.prog.webi.faculdade.crud.service.impl;

import br.ueg.prog.webi.faculdade.crud.model.Aluguel;
import br.ueg.prog.webi.faculdade.crud.model.Carro;
import br.ueg.prog.webi.faculdade.crud.model.Cliente;
import br.ueg.prog.webi.faculdade.crud.repository.AluguelRepository;
import br.ueg.prog.webi.faculdade.crud.service.AluguelService;
import br.ueg.prog.webi.faculdade.crud.service.CarroService;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private CarroService carroService;

    @Autowired
    private AluguelRepository aluguelRepository;

    @Override
    public Aluguel incluir(Carro carro, Aluguel aluguel, Cliente cliente) {
        aluguel.setCarro(carro);
        aluguel.setCliente(cliente);
        aluguel.setValor(this.calcularValorTotal(aluguel));
        carroService.alugar(aluguel.getCarro().getPlaca());
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
        this.carroService.desalugar(aluguelExcluir.getCarro().getPlaca());
        return aluguelExcluir;
    }

    @Override
    public List<Aluguel> listarTodos() {
        return aluguelRepository.findAll();
    }

    @Override
    public Double calcularValorTotal(Aluguel aluguel) {
        Locale.setDefault(new Locale("pt", "BR"));
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        Period periodo;
        try {
            LocalDate data_inicio = new LocalDate(formato.parse(aluguel.getData_inicio()));
            LocalDate data_fim = new LocalDate(formato.parse(aluguel.getData_fim()));
            periodo = new Period(data_inicio, data_fim);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return aluguel.getCarro().getDiaria() * periodo.getDays();
    }
}

