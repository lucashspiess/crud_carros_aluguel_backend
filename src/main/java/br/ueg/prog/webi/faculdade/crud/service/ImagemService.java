package br.ueg.prog.webi.faculdade.crud.service;

import br.ueg.prog.webi.api.service.CrudService;
import br.ueg.prog.webi.faculdade.crud.model.Imagem;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImagemService extends CrudService<Imagem, Long> {
}
