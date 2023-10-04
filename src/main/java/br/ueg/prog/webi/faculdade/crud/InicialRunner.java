package br.ueg.prog.webi.faculdade.crud;

import br.ueg.prog.webi.faculdade.crud.model.Carro;
import br.ueg.prog.webi.faculdade.crud.model.Imagem;
import br.ueg.prog.webi.faculdade.crud.model.Tipo;
import br.ueg.prog.webi.faculdade.crud.model.Usuario;
import br.ueg.prog.webi.faculdade.crud.repository.UsuarioRepository;
import br.ueg.prog.webi.faculdade.crud.service.ImagemService;
import br.ueg.prog.webi.faculdade.crud.service.impl.CarroServiceImpl;
import br.ueg.prog.webi.faculdade.crud.service.impl.DiretorioServiceImpl;
import br.ueg.prog.webi.faculdade.crud.service.impl.ImagemServiceImpl;
import br.ueg.prog.webi.faculdade.crud.service.impl.TipoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;


@Component
public class InicialRunner extends Thread implements ApplicationRunner {

    @Autowired
    private CarroServiceImpl carroService;

    @Autowired
    private TipoServiceImpl tipoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ImagemServiceImpl imagemService;

    //mudar de acordo com a pasta utilizada para salvar as fotos
    private final String ORIGEM = "C:\\Portable20231\\workspace\\prog.webi.faculdade.crud\\src\\carros-fotos";


    public void initDados() throws IOException {

        Locale.setDefault(new Locale("pt-br"));

        Tipo tipo = Tipo.builder()
                .nome("SUV")
                .descricao("Grande")
                .build();

        tipo = this.tipoService.incluir(tipo);

        byte[] bytes = Files.readAllBytes(Paths.get(ORIGEM + "\\volkswagen_nivus.jpg"));

        Imagem imagem = Imagem.builder()
                .img(bytes)
                .build();
        imagem =  this.imagemService.incluir(imagem);

        Carro carro = Carro.builder()
                .ano(2020)
                .marca("Volkswagen")
                .cor("Preto")
                .diaria(50.50)
                .modelo("Nivus")
                .imagem_id(imagem.getId())
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

        bytes = Files.readAllBytes(Paths.get(ORIGEM + "\\bmw_x6.jpg"));

        imagem = Imagem.builder()
                .img(bytes)
                .build();
        imagem =  this.imagemService.incluir(imagem);

        carro = Carro.builder()
                .ano(2020)
                .marca("BMW")
                .cor("Preto")
                .diaria(502.50)
                .modelo("X6")
                .imagem_id(imagem.getId())
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

        bytes = Files.readAllBytes(Paths.get(ORIGEM + "\\audi_r8.jpg"));

        imagem = Imagem.builder()
                .img(bytes)
                .build();
        imagem =  this.imagemService.incluir(imagem);

        carro = Carro.builder()
                .ano(2020)
                .marca("Audi")
                .cor("Preto")
                .diaria(546.73)
                .modelo("R8")
                .imagem_id(imagem.getId())
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
    public void run(ApplicationArguments args) {
        try {
            initDados();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
