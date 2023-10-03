package br.ueg.prog.webi.faculdade.crud.service.impl;

import br.ueg.prog.webi.api.exception.ApiMessageCode;
import br.ueg.prog.webi.api.exception.BusinessException;
import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.faculdade.crud.model.Imagem;
import br.ueg.prog.webi.faculdade.crud.repository.ImagemRepository;
import br.ueg.prog.webi.faculdade.crud.service.ImagemService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImagemServiceImpl extends BaseCrudService<Imagem, Long, ImagemRepository> implements ImagemService {

    @Autowired
    private ImagemRepository repository;

    private final String CAMINHO_FRONT = "C:\\Portable20231\\workspace\\ueg-prog-webi-faculdade\\src\\carros";
    private final String CAMINHO_PASTA = "C:\\Portable20231\\workspace\\prog.webi.faculdade.crud\\src\\carros-fotos";
    private final String PATH_REFERENCE = "carros";

    @Override
    protected void prepararParaIncluir(Imagem entidade) {

    }

    @Override
    protected void validarDados(Imagem entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Imagem entidade) {

    }

    public Long incluir(MultipartFile imagemASalvar) throws IOException {

        String caminhoFront = CAMINHO_FRONT + "\\" + imagemASalvar.getOriginalFilename();
        String caminhoArquivo = CAMINHO_PASTA + "\\" + imagemASalvar.getOriginalFilename();
        String pathReference = PATH_REFERENCE + "/" + imagemASalvar.getOriginalFilename();
        Path src = Path.of(caminhoArquivo);
        Path dest = Path.of(caminhoFront);

        try {
            Imagem imagem = this.repository.save(Imagem.builder()
                    .nome(imagemASalvar.getOriginalFilename())
                    .tipo(imagemASalvar.getContentType())
                    .caminhoArq(caminhoArquivo)
                            .caminhoFront(caminhoFront)
                    .pathReference(pathReference)
                    .build());

            imagemASalvar.transferTo(new File(caminhoArquivo));
            Files.copy(src, dest.resolve(src.relativize(src)),
                    StandardCopyOption.REPLACE_EXISTING);

            return imagem.getId();
        } catch (DataIntegrityViolationException | ConstraintViolationException var3) {
            throw new BusinessException(ApiMessageCode.ERRO_BD, new Object[]{var3.getMessage()});
        }
    }

    public boolean excluirFoto(String caminho){
        Path path = Paths.get(caminho);
        try {
            return Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
