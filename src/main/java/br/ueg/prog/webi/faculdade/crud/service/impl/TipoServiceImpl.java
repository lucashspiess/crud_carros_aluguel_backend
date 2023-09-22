package br.ueg.prog.webi.faculdade.crud.service.impl;

import br.ueg.prog.webi.api.service.BaseCrudService;
import br.ueg.prog.webi.faculdade.crud.model.Tipo;
import br.ueg.prog.webi.faculdade.crud.repository.TipoRepository;
import br.ueg.prog.webi.faculdade.crud.service.TipoService;
import org.springframework.stereotype.Service;

@Service
public class TipoServiceImpl extends BaseCrudService<Tipo, Long, TipoRepository>
        implements TipoService {


    @Override
    protected void prepararParaIncluir(Tipo entidade) {

    }

    @Override
    protected void validarDados(Tipo entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Tipo entidade) {

    }
}
