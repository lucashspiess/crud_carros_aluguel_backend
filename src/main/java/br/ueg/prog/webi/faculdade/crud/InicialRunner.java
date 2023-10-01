package br.ueg.prog.webi.faculdade.crud;

import br.ueg.prog.webi.faculdade.crud.model.Carro;
import br.ueg.prog.webi.faculdade.crud.model.Imagem;
import br.ueg.prog.webi.faculdade.crud.model.Tipo;
import br.ueg.prog.webi.faculdade.crud.model.Usuario;
import br.ueg.prog.webi.faculdade.crud.repository.CarroRepository;
import br.ueg.prog.webi.faculdade.crud.repository.TipoRepository;
import br.ueg.prog.webi.faculdade.crud.repository.UsuarioRepository;
import br.ueg.prog.webi.faculdade.crud.service.impl.CarroServiceImpl;
import br.ueg.prog.webi.faculdade.crud.service.impl.ImagemServiceImpl;
import br.ueg.prog.webi.faculdade.crud.service.impl.TipoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
public class InicialRunner implements ApplicationRunner {

    @Autowired
    private CarroServiceImpl carroService;

    @Autowired
    private TipoServiceImpl tipoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ImagemServiceImpl imagemService;


    public void initDados(){

        Locale.setDefault(new Locale("pt-br"));

        Tipo tipo = Tipo.builder()
                .nome("SUV")
                .descricao("Grande")
                .build();

        tipo = this.tipoService.incluir(tipo);

        Imagem imagem = Imagem.builder()
                .pathReference("assets/volkswagen_nivus.jpg")
                .caminhoArq("C:\\Portable20231\\workspace\\ueg-prog-webi-faculdade\\src\\assets\\volkswagen_nivus.jpg")
                .tipo("imagem/jpeg")
                .nome("volkswagen_nivus.jpg")
                .build();

        imagem = this.imagemService.incluir(imagem);

        Carro carro = Carro.builder()
                .ano(2020)
                .marca("Volkswagen")
                .cor("Preto")
                .diaria(50.50)
                .modelo("Nivus")
                .imagem(imagem)
                .placa("ABC1234")
                .tipo(tipo)
                .quilometragem(0l)
                .status("Disponível")
                .build();

        carro = this.carroService.incluir(carro);

        tipo = Tipo.builder()
                .nome("Sedã")
                .descricao("Longo")
                .build();

        tipo = this.tipoService.incluir(tipo);

        imagem = Imagem.builder()
                .pathReference("assets/bmw_x6.jpg")
                .caminhoArq("C:\\Portable20231\\workspace\\ueg-prog-webi-faculdade\\src\\assets\\bmw_x6.jpg")
                .tipo("imagem/jpeg")
                .nome("bmw_x6.jpg")
                .build();

        imagem = this.imagemService.incluir(imagem);

        carro = Carro.builder()
                .ano(2020)
                .marca("BMW")
                .cor("Preto")
                .diaria(502.50)
                .modelo("X6")
                .imagem(imagem)
                .placa("DEF5432")
                .tipo(tipo)
                .quilometragem(231l)
                .status("Disponível")
                .build();

        carro = this.carroService.incluir(carro);

        tipo = Tipo.builder()
                .nome("Esportivo")
                .descricao("Rápido")
                .build();

        tipo = this.tipoService.incluir(tipo);

        imagem = Imagem.builder()
                .pathReference("assets/audi_r8.jpg")
                .caminhoArq("C:\\Portable20231\\workspace\\ueg-prog-webi-faculdade\\src\\assets\\audi_r8.jpg")
                .tipo("imagem/jpeg")
                .nome("audi_r8.jpg")
                .build();

        imagem = this.imagemService.incluir(imagem);

        carro = Carro.builder()
                .ano(2020)
                .marca("Audi")
                .cor("Preto")
                .diaria(546.73)
                .modelo("r8")
                .imagem(imagem)
                .placa("GLK9865")
                .tipo(tipo)
                .quilometragem(10l)
                .status("Disponível")
                .build();

        carro = this.carroService.incluir(carro);


        Usuario user = new Usuario();
        user.setNome("Ademir");
        user.setSenha("admin");
        user.setLogin("admin");
        user.setStatus(true);
        user.setRole("ROLE_ADMIN");
        user.setEmail("admin@gmail.com");
        user.setCodigo(null);

        user = usuarioRepository.save(user);
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
