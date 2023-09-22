package br.ueg.prog.webi.faculdade.crud.mapper;

import br.ueg.prog.webi.api.mapper.BaseMapper;
import br.ueg.prog.webi.faculdade.crud.dto.TipoDTO;
import br.ueg.prog.webi.faculdade.crud.model.Tipo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoMapper extends BaseMapper<Tipo, TipoDTO> {
}
