package br.ueg.prog.webi.faculdade.crud.controller;

import br.ueg.prog.webi.api.controller.CrudController;
import br.ueg.prog.webi.faculdade.crud.dto.TipoDTO;
import br.ueg.prog.webi.faculdade.crud.mapper.TipoMapper;
import br.ueg.prog.webi.faculdade.crud.model.Tipo;
import br.ueg.prog.webi.faculdade.crud.service.impl.TipoServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/${app.api.version}/tipo")
public class TipoController extends CrudController<Tipo, TipoDTO, Long, TipoMapper, TipoServiceImpl> {

}
