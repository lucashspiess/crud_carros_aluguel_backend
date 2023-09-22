package br.ueg.prog.webi.faculdade.crud;

import br.ueg.prog.webi.faculdade.crud.model.Carro;
import br.ueg.prog.webi.faculdade.crud.model.Tipo;
import br.ueg.prog.webi.faculdade.crud.repository.CarroRepository;
import br.ueg.prog.webi.faculdade.crud.service.impl.TipoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InicialRunner implements ApplicationRunner {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private TipoServiceImpl tipoService;

    public void initDados(){

        Tipo tipo = Tipo.builder()
                .nome("SUV")
                .descricao("Grande")
                .build();

        tipoService.incluir(tipo);

        Carro carro = Carro.builder()
                .ano(2020)
                .cor("Preto")
                .diaria(50.50)
                .modelo("Nivus")
                .placa("ABC1234")
                .tipo(tipo)
                .quilometragem(0l)
                .status("Disponível")
                .build();

        carro = carroRepository.save(carro);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {

        try {
            this.initDados();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
