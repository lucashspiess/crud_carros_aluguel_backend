package br.ueg.prog.webi.faculdade.crud.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.faculdade.crud.model.Imagem;
import br.ueg.prog.webi.faculdade.crud.repository.ImagemRepository;
import br.ueg.prog.webi.faculdade.crud.service.ImagemService;
import org.springframework.stereotype.Service;


@Service
public class ImagemServiceImpl extends BaseCrudService<Imagem, Long, ImagemRepository> implements ImagemService {

    @Override
    protected void prepararParaIncluir(Imagem entidade) {

    }

    @Override
    protected void validarDados(Imagem entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Imagem entidade) {

    }
}
