package br.ueg.prog.webi.faculdade.crud;

import br.ueg.prog.webi.faculdade.crud.model.Carro;
import br.ueg.prog.webi.faculdade.crud.repository.CarroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CarroRepository carroRepository){
		return args -> {
			Carro carro = new Carro();
			carro.setPlaca("ABC1234");
			carro.setAno(2020);
			carro.setCor("Preto");
			carro.setModelo("Nivus");
			carro.setQuilometragem(0l);
			carro.setStatus("Disponível");
			carro.setDiaria(50.50);
			carro = carroRepository.save(carro);
			Optional<Carro>c1 = carroRepository.findByModelo(carro.getModelo());
		};
	}
}
